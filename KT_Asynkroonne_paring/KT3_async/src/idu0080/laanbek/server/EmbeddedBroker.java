package idu0080.laanbek.server;

import org.apache.activemq.broker.BrokerService;
import org.apache.log4j.Logger;

public class EmbeddedBroker {
	private static final Logger log = Logger.getLogger(EmbeddedBroker.class);
    public static final String PORT = "61618";
    public static final String URL = "tcp://localhost:" + PORT;
    
    private EmbeddedBroker() {
    	
    }
    
    public static void main(String[] args) throws Exception {
    	BrokerService broker1 = new BrokerService();
    	
    	broker1.setBrokerName("TELLIMUSTE_VAHENDAJA");
    	broker1.addConnector(URL);
    	broker1.start();
    	
    	
    	
    	System.out.println("Start TELLIMUSTE VAHENDAJA on " + URL);
    	log.info("Start TELLIMUSTE VAHENDAJA on " + URL);
    	
    	// let's wait forever
    	Object lock = new Object();
    	// synchronize so the only one thread can lock object
    	synchronized (lock) {
			// wait forever
    		lock.wait();
		}
    }
}
