package com.juno.bg09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public List<User> list() {
		// ResultSet 사용없이 검색 결과 레코드의 필드를 Dto 변수에 넣고 list에 add동작을 실행합니다.
		return template.query(
				"select * from myuser"
				, new BeanPropertyRowMapper<User>(User.class)
		);
	}
}
