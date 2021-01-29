package com.juno.bg13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bg13.dao.IBoardDao;
import com.juno.bg13.dto.Board;
import com.juno.bg13.dto.Reply;
import com.juno.bg13.util.Paging;

@Service
public class BoardService {
	
	@Autowired
	IBoardDao bdao;

	public List<Board> getAll(Paging paging) {
		List<Board> list = bdao.getAll(paging);
		for (Board b: list) {
			b.setReplycnt(bdao.getReplyCnt(b.getNum()));
		}
		return list;
	}

	public int getAllCount() {
		return bdao.getAllCount();
	}

	public Board readBoard(int num) {
		bdao.incrementReadcount(num);
		return bdao.getBoard(num);
	}

	public List<Reply> selectReply(int num) {
		return bdao.selectReply(num);
	}

	public int insertReply(Reply r) {
		return bdao.insertReply(r);		
	}

	public int deleteReply(int num) {
		return bdao.deleteReply(num);
	}

}
