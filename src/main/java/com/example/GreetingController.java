package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class GreetingController {

    @Get("/greeting")
    public Greeting greeting(){
        return new Greeting("micronaut","This is maicronaut service");
    }
}
