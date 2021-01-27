package com.juno.bg06;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidController {

    @RequestMapping(value = "/")
    public String insert1() {
        return "createPage";
    }

    @RequestMapping(value = "/create")
    public String create(@ModelAttribute("c") Content c, BindingResult result) {
        /**
            BindingResult : key, value로 구성된 오류내용 저장클래스
            위 클래스 형태의 레퍼런스 변수를 선언하고, 시작
        */
        System.out.println("c #########################################");
        System.out.println(c);

        ContentValidator validator = new ContentValidator();
        validator.validate(c, result);

        if (result.hasErrors()) {
            return "createPage";
            // model.addAttribute("c", c); -> @ModelAttribute
        } else {
            return "createDonePage";
        }
    }
}
