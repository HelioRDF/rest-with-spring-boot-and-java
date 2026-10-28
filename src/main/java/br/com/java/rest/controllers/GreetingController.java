package br.com.java.rest.controllers;


import br.com.java.rest.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/start")
public class GreetingController {

    private static AtomicLong id = new AtomicLong();
    private static String template = "Hi %s";

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "EveryBody") String name) {
        return new Greeting(id.incrementAndGet(), String.format(template, name));
    }
}
