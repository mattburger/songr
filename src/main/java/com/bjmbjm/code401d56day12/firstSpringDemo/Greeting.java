package com.bjmbjm.code401d56day12.firstSpringDemo;
import javax.persistence.*;

// hello, in English
// hola, in Spanish
// good day, in English

// Greeting model
@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String language;
    String text;



    public Greeting() {}
    public Greeting(String language, String text) {
        this.language = language;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getLanguage() {
        return this.language;
    }
}