package com.juno.bg14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bg14.dao.IBoardDao;
import com.juno.bg14.dto.Board;
import com.juno.bg14.dto.Reply;
import com.juno.bg14.util.Paging;

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
	
	public Board getBoard(int num) {
		return bdao.getBoard(num);
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

	public int updateBoard(Board b) {
		return bdao.updateBoard(b);
	}

	public void removeBoard(int num) {
		bdao.deleteReplyByBoard(num);
		bdao.deleteBoard(num);
	}

	public int insertBoard(Board b) {
		return bdao.insertBoard(b);
	}

}
