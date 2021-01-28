package com.juno.bg12.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bg12.dto.Bbs;

@Mapper
public interface IBbsDao {
	List<Bbs> list();
	Bbs view(String id);
	int write(Bbs b);
	int update(Bbs b);
	int delete(Bbs b);
}
