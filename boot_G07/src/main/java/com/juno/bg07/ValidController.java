package com.juno.bg07;

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
        ContentValidator validator = new ContentValidator();
        validator.validate(c, result);

        if (result.hasErrors()) {
            return "createPage";
        } else {
            return "createDonePage";
        }
    }
}
