package com.juno.bg13.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bg13.dao.IMemberDao;
import com.juno.bg13.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	IMemberDao md;

	public Member getMember(String id) {
		return md.getMember(id);
	}

	public int insertMember(String id, String pw, String name, String email, String phone1, String phone2, String phone3) {
		return md.insertMember(id, pw, name, email, phone1, phone2, phone3);
	}

	public int updateMember(Member m) {
		return md.updateMember(m);
	}
}
