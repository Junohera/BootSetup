package com.juno.bg13.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bg13.dto.Board;
import com.juno.bg13.dto.Reply;
import com.juno.bg13.util.Paging;

@Mapper
public interface IBoardDao {
	List<Board> getAll(Paging paging);
	Board getBoard(int num);
	int getAllCount();
	int incrementReadcount(int num);
	List<Reply> selectReply(int num);
	int getReplyCnt(int num);
}
