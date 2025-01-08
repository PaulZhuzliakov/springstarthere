package org.example.demo666.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/home")
    public String home(Model page) {
        page.addAttribute("username", "Admin");
        page.addAttribute("color", "red");
        return "home0.html";
    }
}
