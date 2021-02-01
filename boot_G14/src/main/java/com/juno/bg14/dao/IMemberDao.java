package com.juno.bg14.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bg14.dto.Member;

@Mapper
public interface IMemberDao {

	Member getMember(String id);
	int updateMember(Member m);
	int deleteMember(String id);
	int insertMember(String id, String pw, String name, String email, String phone1, String phone2, String phone3); // 일부러 여러개보내는 방법으로 진행
	List<Member> list();
}
