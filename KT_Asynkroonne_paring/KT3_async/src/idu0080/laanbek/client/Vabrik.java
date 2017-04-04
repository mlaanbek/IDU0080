package idu0080.laanbek.client;

import java.math.BigDecimal;
import java.util.List;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import idu0080.laanbek.server.EmbeddedBroker;
import idu0080.laanbek.types.Tellimus;
import idu0080.laanbek.types.TellimuseRida;

public class Vabrik implements MessageListener, ExceptionListener {
	public static final String TELLIMUSE_EDASTAMINE = "tellimuse.edastamine";
	public static final String TELLIMUSE_VASTUS = "tellimuse.vastus";
	private static String user = ActiveMQConnection.DEFAULT_USER;
	private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
	private static String url = EmbeddedBroker.URL;
	private static long timeToLive = 1000000;
	
	private static MessageProducer messageProducer;
	private static Session session;
	
	public static void main(String[] args) throws JMSException  {
		Vabrik vabrik = new Vabrik();
		
		System.out.println("Consuming queue: " + TELLIMUSE_EDASTAMINE);
		
		Connection connection = null;
		ActiveMQConnectionFactory connectionFactory = 
				new ActiveMQConnectionFactory(user, password, url);

		connection = connectionFactory.createConnection();
		connection.setExceptionListener(vabrik);
		connection.start();
		
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(TELLIMUSE_EDASTAMINE);
		MessageConsumer messageConsumer = session.createConsumer(destination);
		messageConsumer.setMessageListener(vabrik);
		
		Destination confirmationDestination = session.createQueue(TELLIMUSE_VASTUS);
		messageProducer = session.createProducer(confirmationDestination);
		messageProducer.setTimeToLive(timeToLive);
	}

	@Override
	public void onMessage(Message message) {
		try {
				if (message instanceof TextMessage) {
					TextMessage txtMsg = (TextMessage) message;
					String msg = txtMsg.getText();
					System.out.println("\nSaabunud tekstisõnum: " + msg);
				} else if (message instanceof ObjectMessage) {
					ObjectMessage objectMessage = (ObjectMessage) message;
					if(objectMessage.getObject() instanceof Tellimus) {
					    
						Tellimus tellimus = (Tellimus) objectMessage.getObject();
					    BigDecimal tellimuseSumma = BigDecimal.ZERO;
						
						List<TellimuseRida> tellimuseRead = tellimus.getTellimuseRead();
						
						System.out.println("Vastu võetud tellimus (" 
								+ tellimus.getTellimuseRead().size() + " toodet. Tellimuse sisu: ");
						
						for (int i = 0; i < tellimuseRead.size(); i++) {						
							TellimuseRida rida = tellimuseRead.get(i);
							BigDecimal kogus = BigDecimal.valueOf(rida.getKogus());
							System.out.println("Toode: " + rida.getToode().getNimetus());
							System.out.println("kogus: " + kogus);
							BigDecimal hind = rida.getToode().getHind();
							System.out.println("hind: " + hind);
							BigDecimal reaSumma = hind.multiply(kogus);
							System.out.println("Reasumma: " + reaSumma + "\n");
							tellimuseSumma = tellimuseSumma.add(reaSumma);	
						}
						System.out.println("----------------------------");
						System.out.println("Tellimuse summa: " + tellimuseSumma);
						
						String responseText = String.format("Toodete arv kokku: %s, hind kokku: %s.",
								tellimuseRead.size(), tellimuseSumma);
						
						sendAnswer(responseText);
					}
				} 
			} catch (JMSException e) {
				e.printStackTrace();
			}	
	}


	private void sendAnswer(String responseText) {
		try {
			TextMessage responseMessage = session.createTextMessage(responseText);
			System.out.println("Saadan vastuse: " + responseMessage.getText());
			messageProducer.send(responseMessage);
			
			Object lock = new Object();
			synchronized (lock) {
				lock.wait(200);
			}
		} catch (JMSException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onException(JMSException ex) {
		System.out.println("JMS Exception occured. Shutting down client.");
		ex.printStackTrace();
	}

}
