package com.juno.bg06;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Content.class.isAssignableFrom(clazz); // 검증할 객체의 클래스 타입정보
	}

	@Override
	public void validate(Object target, Errors errors) {
		Content c = (Content) target;
		String sWriter = c.getWriter();
		String sContent = c.getContent();
		
		if (sWriter == null || sWriter.trim().isEmpty()) {
			System.out.println("writer is null or empty");
			errors.rejectValue("writer", "trouble");
		}
		
		if (sContent == null || sContent.trim().isEmpty()) {
			System.out.println("content is null or empty");
			errors.rejectValue("content", "trouble");
		}
	}
	
}