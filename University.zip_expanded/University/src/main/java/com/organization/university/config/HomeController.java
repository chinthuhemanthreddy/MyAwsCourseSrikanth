package com.organization.university.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	@RequestMapping("/alm")
    public String index() {
        return "redirect:swagger-ui.html";
    }
}