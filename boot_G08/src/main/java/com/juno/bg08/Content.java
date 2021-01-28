package com.juno.bg08;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Content {
	private int id;
	
	@NotNull(message="Writer is Null")
	@NotEmpty(message="Writer is Empty")
	@NotBlank(message="writer is Blank")
	@Size(min=3, max=20, message="writer min 3, max20.")
	private String writer;
	
	@NotNull(message="Content is Null")
	@NotEmpty(message="Content is Empty")
	private String content;
}
