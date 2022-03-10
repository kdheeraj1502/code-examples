package com.javadevjournal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/search/v1")
public class FilterExampleController {

    @GetMapping
    public String greeting(){
        return "Hello World";
    }

    @GetMapping(value = "/autosuggest")
    public String customGreetings(){
        return "Hello From Custom Greetings";
    }
    
    @GetMapping(value = "/search")
    public String search() {
    	return "we are searching";
    }
}
