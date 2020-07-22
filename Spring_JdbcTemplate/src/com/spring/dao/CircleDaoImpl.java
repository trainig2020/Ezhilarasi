package com.spring.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.spring.model.Circle;

@Component
public class CircleDaoImpl {

	// @Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = new JdbcTemplate();

	public int getCircleCount() {
		String sql = "select count(*) from circle";
		// jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}
	
	public String getCircleName(int id){
		String sql = "select name from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
	}
	
	

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Circle getCircle(int circleid) {
		Connection con = null;
		try {

			con = dataSource.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from circle where id=?");
			ps.setInt(1, circleid);

			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(circleid, rs.getString("name"));
			}
			rs.close();
			ps.close();
			// con.close();
			return circle;
		} catch (Exception e) {
			throw new RuntimeException(e);

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
