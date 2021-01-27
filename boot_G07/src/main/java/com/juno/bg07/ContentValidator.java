package com.juno.bg07;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ContentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Content.class.isAssignableFrom(clazz); // 검증할 객체의 클래스 타입정보
	}

	@Override
	public void validate(Object target, Errors errors) {
		Content c = (Content) target;
		
		// empty체크
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "writer", "writer is empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "content is empty.");
		
		// 특정 멤버변수의 글자수 점검
		String sWriter = c.getWriter();
		if (sWriter.length() < 3) { // 3글자 미만
			errors.rejectValue("writer", "writer is too short");
		}
		
		
		/** :ASIS
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
		*/
	}
	
}