package com.spring.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.model.Circle;

@Component
public class CircleDaoImpl {

	// @Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate ;

	public int getCircleCount() {
		String sql = "select count(*) from circle";
		// jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForObject(sql, Integer.class);

	}
	
	public Circle getCircleById(int id){
		String sql = "select * from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{id}, new circleMapper());
	}
	
	public List<Circle> getCircle(){
		String sql = "select * from circle";
		return jdbcTemplate.query(sql, new circleMapper()); 
	}
	
	private static final class circleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
			
		}
		
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

	/*public Circle getCircle(int circleid) {
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
*/
	
	
	public void insertCircle(Circle circle){
		String sql = "insert into circle(id,name) values (?,?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(), circle.getName()});
		
	}
	
	public void createTable(){
		String sql = "create table triangle(id int, name varchar(30))";
		jdbcTemplate.execute(sql);
		System.out.println("table created");
	}
}
