package com.pack.controller;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class UserDaoImpl{
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template){
		this.template=template;
	}
	public void register(User user) {
	String sql="insert into stud99 values(?,?,?,?,?)";	
	  template.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getAddress(),user.getPhone());	
	}

	public User validateUser(Login login) {
		String sql="select * from stud99 where username='"+login.getUsername()+"' and password='"+login.getPassword()+"'";
		List<User> list=template.query(sql,new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int i) throws SQLException {
				User u=new User();
				u.setUsername(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setAddress(rs.getString(4));
				u.setPhone(rs.getInt(5));
				return u;
			}
		 
		});
		return list.size()>0 ? list.get(0) : null;
	}

}
