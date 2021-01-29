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

	public int insertMember(Member m) {
		return md.insertMember(m.getId(), m.getPw(), m.getName(), m.getEmail(), m.getPhone1(), m.getPhone2(), m.getPhone3());
	}
}
