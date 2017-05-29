package ttu.idu0080.ee.courier.service;

import java.util.List;

import ttu.idu0080.ee.courier.Courier;


public interface ICourierService {
	public List<Courier> getAllCouriers();
	
	public Courier getCourierById(int courierId);
}
