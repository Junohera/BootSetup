package com.juno.bg13.dto;

import java.sql.Timestamp;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class Reply {
	private int num;
    private int boardnum;
    private String userid;
    private Timestamp writedate;
    @NotEmpty(message="content is Empty")
    private String content;
}
