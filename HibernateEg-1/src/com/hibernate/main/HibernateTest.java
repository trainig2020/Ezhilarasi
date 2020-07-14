package com.hibernate.main;

import java.util.Date;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("Sandhiya");
		user.setJoinedDate(new Date());
		user.setAddress("First user address");
		user.setDescription("any description");
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("Ezhil");
		user2.setJoinedDate(new Date());
		user2.setAddress("second user address");
		user2.setDescription("any description");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		/*user=null;
		session=sf.openSession();
		session.beginTransaction();
	    user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User name is : "+user.getUserName());
		*/

	}

}
