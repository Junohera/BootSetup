package com.juno.bm01.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.juno.bm01.dto.Qna;

@Mapper
public interface IQnaDao {

	List<Qna> listQna(String id);

	Qna getQna(int qseq);

	int insertQna(Qna q);

}
