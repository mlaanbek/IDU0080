package com.idu0080.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idu0080.dao.WashInputDao;
import com.idu0080.entities.WashInput;
import com.idu0080.services.WashInputServices;

@Service
public class WashInputServicesImpl implements WashInputServices {
	
	@Autowired
	WashInputDao washInputDao;
	
	public List<WashInput> getAllInputs() {
		return washInputDao.getAllInputs();
	}

}
