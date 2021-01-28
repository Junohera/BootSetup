package com.juno.bg10;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BbsDao implements IbbsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Bbs> list() {
		return jdbcTemplate.query(
				"select * from bbs order by id desc"
				, new BeanPropertyRowMapper<Bbs>(Bbs.class));
	}

	@Override
	public Bbs view(String id) {
		return jdbcTemplate.queryForObject(
				"select * from bbs where id = ?"
				, new BeanPropertyRowMapper<Bbs>(Bbs.class)
				, id);
	}

	@Override
	public int write(Bbs b) {
		return jdbcTemplate.update(
				"insert into bbs values(bbs_seq.nextVal, ?, ?, ?)"
				, b.getWriter(), b.getTitle(), b.getContent()
				);
	}

	@Override
	public int update(Bbs bbs) {
		return 0;
	}

	@Override
	public int delete(String id) {
		return 0;
	}

}
