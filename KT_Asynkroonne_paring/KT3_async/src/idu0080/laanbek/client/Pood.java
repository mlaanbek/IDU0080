package idu0080.laanbek.client;

import java.math.BigDecimal;
import java.util.Date;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import idu0080.laanbek.server.EmbeddedBroker;
import idu0080.laanbek.types.Tellimus;
import idu0080.laanbek.types.TellimuseRida;
import idu0080.laanbek.types.Toode;


public class Pood {
	private static final Logger log = Logger.getLogger(Pood.class);
	public static final String TELLIMUSE_EDASTAMINE = "tellimuse.edastamine";
	public static final String TELLIMUSE_VASTUS = "tellimuse.vastus";
	
	private String user = ActiveMQConnection.DEFAULT_USER;// brokeri jaoks vaja
	private String password = ActiveMQConnection.DEFAULT_PASSWORD;
	
	long sleepTime = 1000; // 1000ms

	private int messageCount = 10;
	private long timeToLive = 1000000;
	private String url = EmbeddedBroker.URL;

	public static void main(String[] args) {
		Pood pood = new Pood();
		pood.run();
	}

	private void run() {
		Connection connection = null;
		try {
			
			System.out.println("Connecting to URL: " + url);
			System.out.println("Sleeping between publish " + sleepTime + " ms");
			
			if (timeToLive != 0) {
				System.out.println("Messages time to live " + timeToLive + " ms");
			}
			
			ActiveMQConnectionFactory connectionFactory = 
					new ActiveMQConnectionFactory(user, password, url);
			
			connection = connectionFactory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			// orders destination
			Destination orderDestination = session.createQueue(TELLIMUSE_EDASTAMINE);
			MessageProducer messageProducer = session.createProducer(orderDestination);
			messageProducer.setTimeToLive(timeToLive);
			sendTellimus(session, messageProducer);
			
			Destination confirmationDestination = session.createQueue(TELLIMUSE_VASTUS);
			MessageConsumer messageConsumer = session.createConsumer(confirmationDestination);
			messageConsumer.setMessageListener(new MessageListenerImpl());
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	protected void sendTellimus(Session session, MessageProducer producer) throws Exception {
		for (int i = 1; i <= messageCount || messageCount == 0; i++) {
			ObjectMessage objectMessage = session.createObjectMessage();

			// loome tellimuse
			Tellimus tellimus = new Tellimus();
			
			Toode toode1 = new Toode(i, "Toode " + (i), BigDecimal.valueOf(50 % i + 1));
			Toode toode2 = new Toode(i, "Toode " + (i+1), BigDecimal.valueOf(50 % i + 2));

			TellimuseRida tellimuserida = new TellimuseRida(toode1, 10 % i + 1);	
			tellimus.addTellimuseRida(tellimuserida);
			
			tellimuserida = new TellimuseRida(toode2, 20 % i + 2);
			tellimus.addTellimuseRida(tellimuserida);
			
			objectMessage.setObject(tellimus);
			producer.send(objectMessage);
			
			TextMessage textMessage = session.createTextMessage(createMessageText(i));
			log.debug("Sending message: " + textMessage.getText());
			System.out.println("Saadan tellimuse: " + textMessage.getText());
			producer.send(textMessage);
			
			// paus
			Thread.sleep(sleepTime);
		}
	}


	private String createMessageText(int index) {
		return "Tellimus: " + index + " saadetud: " + (new Date()).toString();
	}

	class MessageListenerImpl implements javax.jms.MessageListener {

		@Override
		public void onMessage(Message message) {
			try {
				// accept only text messages
				if (!(message instanceof TextMessage)) {
					System.out.println("Saabunud teade ei ole textMessage tüüpi.");
					return;
				} else {
					TextMessage txtMessage = (TextMessage) message;
					String msg = txtMessage.getText();
					System.out.println("Saabus teade (" + TELLIMUSE_VASTUS + "): " + msg);
				}
				
			} catch (JMSException e) {
				System.out.println("Caught: " + e);
				e.printStackTrace();
			}	
		}	
	}

}
