package com.idu0080.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.idu0080.dao.WashDao;
import com.idu0080.entities.Wash;

@Repository
@Transactional
public class WashDaoImpl implements WashDao {
	
	@Autowired
	SessionFactory session;

	public List<Wash> getAllWashes() {
		return session.getCurrentSession().createQuery("from Wash").list();
	}

	public void deleteWash(String wash_id) {
		Wash wash = new Wash();
		wash.setWash_id(wash_id);
		try {
			session.getCurrentSession().delete(wash);
		} catch(Exception e) {

		}
	}

	public boolean createOrUpdateWash(Wash wash) {
		session.getCurrentSession().saveOrUpdate(wash);
		return true;
	}

	public List<Wash> searchByWashType(String washType) {
		String hibernateSql = "from Wash w where upper(w.wash_type) like upper(:washtype)";
		Query q = session.getCurrentSession().createQuery(hibernateSql);
		q.setParameter("washtype", "%" + washType + "%");
		return q.list();
	}

	public Wash getWashById(String wash_id) {
		Wash wash = null;
		
		String hql = "from Wash w where upper(w.wash_id) = upper(:id)";
		Query query = session.getCurrentSession().createQuery(hql);
		query.setParameter("id", wash_id);
		wash = (Wash) query.uniqueResult();

		return wash;
	}

}
