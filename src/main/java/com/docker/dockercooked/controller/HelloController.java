package com.docker.dockercooked.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Docker!";
    }

    @GetMapping("/list")
    public List<String> getList() {
        return List.of("Item 1", "Item 2", "Item 3");
    }
}
