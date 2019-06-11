package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Mark this class as a controller so spring boot knows to look at it
@RestController

public class HelloWorldController {

    //specify the route for this method
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello, world! It's a beautiful day today!";
    }
    @GetMapping("/hello/{name}/{from}")
    public String getHelloToUser(@PathVariable String name, @PathVariable int from) {
        return "Hello, " + name + " from Agent " + from * 25;
    }
}
