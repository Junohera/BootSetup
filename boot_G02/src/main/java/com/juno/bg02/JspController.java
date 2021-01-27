package com.juno.bg02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JspController {

    @RequestMapping(value = "/")
    public @ResponseBody String root() {
    	
        return "jsp in gradle";
        // @RequestMapping 값이 "/"이고 리턴값이 "main"이라면
        // htp://localhost:8070/의 결과는 main.jsp이겠지만 (별도 경로 설정 및 폴더 생성 필요)
        // 함수 이름에 @ResponseBody가 있으면 리턴되는 문자열이 웹 브라우저에 직접 쓰여지게됩니다.
    }

    @RequestMapping(value = "/test1")
    public String test1() {
        return "main"; // 실제 호출될 webapp/WEB-INF/views/main.jsp
    }
}
