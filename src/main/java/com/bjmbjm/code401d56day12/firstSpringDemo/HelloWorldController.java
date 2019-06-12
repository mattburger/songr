package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

import java.util.concurrent.atomic.AtomicLong;

// Mark this class as a controller so spring boot knows to look at it
@RestController

public class HelloWorldController {

    //id to track the different queries
    private long counter = 0;
    //specify the route for this method
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello, world! It's a beautiful day today!";
    }
    @GetMapping("/hello/{name}/{from}")
    public String getHelloToUser(@PathVariable String name, @PathVariable int from) {
        return "Hello, " + name + " from Agent " + from * 25;
    }
    @GetMapping("/capitalize/{str}")
    public String capitalizeStr(@PathVariable String str) {

        if(str.equals("")){
            throw new IllegalArgumentException("Path variable cannot be a empty string.");
        }
        return str.toUpperCase();
    }
    @GetMapping("/reverse")
    public SentenceReverse reverseStr(@RequestParam(value = "sentence", defaultValue = "Hello world") String sentence ) {
        return new SentenceReverse(++this.counter, sentence);
    }

}
