package com.example.testemarcos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000",allowedHeaders = "*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH})
public class TestController {
  @GetMapping("/hello")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/hello/{name}")
  public String sayHi(@PathVariable String name) {
    return "Hi! " + name;
  }
}
