package com.spring.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoImpl extends JdbcDaoSupport {
	
	public int getCircleCount() {
		String sql = "select count(*) from circle";
		
		return this.getJdbcTemplate().queryForObject(sql, Integer.class);

	}

}
