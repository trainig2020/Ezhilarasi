package com.spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.spring.model.Circle;

public class CircleDaoImpl {
	public Circle getCircle(int circleid){
		Connection con = null;
		try{
		
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/spring","root","1498");
		PreparedStatement ps = con.prepareStatement("select * from circle where id=?");
		ps.setInt(1,circleid);
		
		Circle circle=null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			circle = new Circle(circleid, rs.getString("name"));
		}
		rs.close();
		ps.close();
		con.close();
		return circle;
		}
		catch(Exception e){
			throw new RuntimeException(e);
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
