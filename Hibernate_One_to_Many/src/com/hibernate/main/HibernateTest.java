package com.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.UserDetails;
import com.hibernate.model.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserName("Ezhil");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Bike");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Car");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		
		vehicle.setUser(user);
		vehicle2.setUser(user);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		//If no cascase types used
		session.save(user);
		session.save(vehicle);
		session.save(vehicle2);
		
		//if cascade type is used
		//session.persist(user);
		
		session.getTransaction().commit();
		session.close();


	}

}
