package ttu.idu0080.ee.courier.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ttu.idu0080.ee.courier.Courier;

@WebService(name = "CourierWebService", targetNamespace = "http://service.courier.ee.idu0080.ttu/")
public interface CourierWebService {

	@WebMethod(operationName = "getAllCouriers", action = "urn:GetAllCouriers")
	List<Courier> getAllCouriers();

	@WebMethod(operationName = "getCourierById", action = "urn:GetCourierById")
	Courier getCourierById(int courierId);

}