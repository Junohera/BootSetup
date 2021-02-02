package com.juno.bm01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bm01.dao.IMemberDao;
import com.juno.bm01.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	IMemberDao mdao;

	public Member getMember(String id) {
		return mdao.getMember(id);
	}
	
	
}
