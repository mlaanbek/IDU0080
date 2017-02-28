package com.idu0080.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.idu0080.dao.WashInputDao;
import com.idu0080.entities.WashInput;

@Repository
@Transactional
public class WashInputDaoImpl implements WashInputDao {
	
	@Autowired
	SessionFactory session;

	public List<WashInput> getAllInputs() {
		return session.getCurrentSession().createQuery("from WashInput").list();
	}

}
