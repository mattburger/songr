
package com.bjmbjm.code401d56day12.firstSpringDemo;
import com.bjmbjm.code401d56day12.firstSpringDemo.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    GreetingRepository greetingRepository;

    @GetMapping("/greetings")
    public String getAllGreetings(Model m) {
        Iterable<Greeting> greetings = greetingRepository.findAll();
        m.addAttribute("greetings", greetings);
        return "allGreetings";
    }

    @PostMapping("/greetings")
    public RedirectView addGreeting(String text, String language) {
        // create a greeting instance
        Greeting g = new Greeting(language, text);
        // save it to the database
        greetingRepository.save(g);
        // send a response
        return new RedirectView("/greetings");
    }
}