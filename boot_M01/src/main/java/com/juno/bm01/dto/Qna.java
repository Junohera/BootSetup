package com.juno.bm01.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Qna {
	private Integer qseq;
	private String subject;
	private String content;
	private String reply;
	private String id;
	private String rep;
	private Timestamp indate;
}
