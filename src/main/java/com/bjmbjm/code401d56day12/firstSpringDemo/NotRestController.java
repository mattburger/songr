package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotRestController {

    @GetMapping("/notresthello")
    public String getNotRestHello(Model m) {
        String[] allTheNames = new String[] {"Michelle", "Tisha", "Robert", "Luke"};
        m.addAttribute("names", allTheNames);
        return "hello";
    }
}
