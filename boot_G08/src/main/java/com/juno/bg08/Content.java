package com.juno.bg08;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Content {
	private int id;
	@NotNull(message="Writer is Null")
	@NotEmpty(message="Writer is Empty")
	private String writer;
	@NotNull(message="Content is Null")
	@NotEmpty(message="Content is Empty")
	private String content;
}
