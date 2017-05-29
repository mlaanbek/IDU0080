package ttu.idu0080.ee.order.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import ttu.idu0080.ee.order.Order;

@WebService(name = "OrderWebService", targetNamespace = "http://service.order.ee.idu0080.ttu/")
public interface OrderWebService {

	@WebMethod(operationName = "getOrderById", action = "urn:GetOrderById")
	Order getOrderById(@WebParam(name = "arg0") int orderId);

}