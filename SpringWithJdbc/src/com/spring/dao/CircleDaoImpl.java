package com.spring.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.model.Circle;

@Component
public class CircleDaoImpl {
	
	@Autowired
	private DataSource dataSource;
	public Circle getCircle(int circleid){
		Connection con = null;
		try{
		
		
		 con=dataSource.getConnection(); 
				
		PreparedStatement ps = con.prepareStatement("select * from circle where id=?");
		ps.setInt(1,circleid);
		
		Circle circle=null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			circle = new Circle(circleid, rs.getString("name"));
		}
		rs.close();
		ps.close();
		//con.close();
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
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
