package com.idu0080.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idu0080.dao.WashDao;
import com.idu0080.entities.Wash;
import com.idu0080.services.WashServices;

@Service
public class WashServicesImpl implements WashServices {
	
	@Autowired
	WashDao washDao;
	
	public List<Wash> getAllWashes() {
		return washDao.getAllWashes();
	}

	public void deleteWash(String wash_id) {
		washDao.deleteWash(wash_id);
	}

	public boolean createOrUpdateWash(Wash wash) {
		return washDao.createOrUpdateWash(wash);
	}

	public List<Wash> searchByWashType(String washType) {
		return washDao.searchByWashType(washType);
	}

	public Wash getWashById(String wash_id) {
		return washDao.getWashById(wash_id);
	}

}
