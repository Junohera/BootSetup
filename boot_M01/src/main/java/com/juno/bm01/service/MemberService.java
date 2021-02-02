package com.juno.bm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bm01.dao.IMemberDao;
import com.juno.bm01.dto.Address;
import com.juno.bm01.dto.Member;

@Service
public class MemberService {
	
	@Autowired
	IMemberDao mdao;

	public Member getMember(String id) {
		return mdao.getMember(id);
	}

	public List<Address> selectAddressByDong(String dong) {
		return mdao.selectAddressByDong(dong);
	}

	public int insertMember(Member m) {
		 return mdao.insertMember(m);
	}

	public int updateMember(Member m) {
		return mdao.updateMember(m);
	}
}
