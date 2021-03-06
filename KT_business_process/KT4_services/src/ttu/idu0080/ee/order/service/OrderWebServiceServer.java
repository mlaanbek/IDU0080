
package ttu.idu0080.ee.order.service;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-05-27T12:52:49.932+03:00
 * Generated source version: 2.7.18
 * 
 */
 
public class OrderWebServiceServer{

    protected OrderWebServiceServer() throws Exception {
        System.out.println("Starting Server");
        Object implementor = new ttu.idu0080.ee.order.service.OrderService();
        String address = "http://localhost:9090/OrderServicePort";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws Exception { 
        new OrderWebServiceServer();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}
 
 