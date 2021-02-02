package com.juno.bm01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bm01.dao.IQnaDao;
import com.juno.bm01.dto.Qna;

@Service
public class QnaService {
	
	@Autowired
	IQnaDao qd;

	public List<Qna> listQna(String id) {
		return qd.listQna(id);
	}

	public Qna getQna(int qseq) {
		return qd.getQna(qseq);
	}

	public int insertQna(Qna q) {
		return qd.insertQna(q);
	}
}
