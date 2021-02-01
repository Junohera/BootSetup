package com.juno.bg13.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.juno.bg14.dto.Board;

public class ContentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {return false;}

	@Override
	public void validate(Object target, Errors errors) {
		Board dto = (Board) target;
		
		if (dto.getPass() == null || dto.getPass().trim().isEmpty())
			errors.rejectValue("pass", "pass check");
		if (dto.getEmail() == null || dto.getEmail().trim().isEmpty())
			errors.rejectValue("email", "email check");
		if (dto.getTitle() == null || dto.getTitle().trim().isEmpty())
			errors.rejectValue("title", "title check");
		if (dto.getContent() == null || dto.getContent().trim().isEmpty())
			errors.rejectValue("content", "content check");
	}

}
