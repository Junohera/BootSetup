package com.juno.bg08;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Content {
	private int id;
	@NotNull(message="Writer is Null")
	private String writer;
	@NotNull(message="Content is Null")
	private String content;
}
