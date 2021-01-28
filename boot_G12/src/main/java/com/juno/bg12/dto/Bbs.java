package com.juno.bg12.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Bbs {
	private String id;
	
	@NotNull(message="Writer is Null")
	@NotEmpty(message="Writer is Empty")
	@NotBlank(message="Writer is Blank")
	private String writer;
	
	@NotNull(message="Title is Null")
	@NotEmpty(message="Title is Empty")
	@NotBlank(message="Title is Blank")
	private String title;
	
	@NotNull(message="Content is Null")
	@NotEmpty(message="Content is Empty")
	@NotBlank(message="Content is Blank")
	private String content;
}
