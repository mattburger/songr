package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NotRestController {

    @GetMapping("/notresthello")
    public String getNotRestHello() {
        return "hello";
    }
}
