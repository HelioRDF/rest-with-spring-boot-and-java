package br.com.java.rest.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
class MathController {

    @RequestMapping("/sum/{a}/{b}")
    public int sum(
            @PathVariable("a") int a,
            @PathVariable("b") int b) {
        return a + b;
    }

    @RequestMapping("/subtract/{a}/{b}")
    public int subtract(
            @PathVariable("a") int a,
            @PathVariable("b") int b) {
        return a - b;
    }

}
