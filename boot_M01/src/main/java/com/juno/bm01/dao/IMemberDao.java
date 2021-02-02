package com.juno.bm01.dao;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bm01.dto.Member;

@Mapper
public interface IMemberDao {

	Member getMember(String id);

}
