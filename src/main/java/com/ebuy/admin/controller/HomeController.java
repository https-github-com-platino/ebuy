package com.ebuy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Abdur Rahim Nishad
 * @created 23/12/2020 - 9:51 PM
 * @project demo
 */

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }
}
