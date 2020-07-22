package com.spring.dao;





import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public int getCircleCount() {
		String hql = "select count(*) from Circle";
		Query query = getSessionfactory().openSession().createQuery(hql);
		return (int) query.uniqueResult();
		
		
		
		

	}

	

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}

}
