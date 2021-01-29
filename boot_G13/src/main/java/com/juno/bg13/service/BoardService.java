package com.juno.bg13.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juno.bg13.dao.IBoardDao;
import com.juno.bg13.dto.Board;
import com.juno.bg13.util.Paging;

@Service
public class BoardService {
	
	@Autowired
	IBoardDao bdao;

	public List<Board> getAll(Paging paging) {
		return bdao.getAll(paging);
	}

	public int getAllCount() {
		return bdao.getAllCount();
	}

}
