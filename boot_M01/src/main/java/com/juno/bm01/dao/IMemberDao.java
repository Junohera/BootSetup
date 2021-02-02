package com.juno.bm01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bm01.dto.Address;
import com.juno.bm01.dto.Member;

@Mapper
public interface IMemberDao {

	Member getMember(String id);
	List<Address> selectAddressByDong(String dong);
	int insertMember(Member m);
	int updateMember(Member m);
}
