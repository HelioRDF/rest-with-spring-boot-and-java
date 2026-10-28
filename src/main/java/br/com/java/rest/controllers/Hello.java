package br.com.java.rest.controllers;

import br.com.java.rest.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

    @RequestMapping("/mensagem")
    public String mensagem() {
        return "777";
    }

    @RequestMapping("/nome")
    public String nome(
            @RequestParam(value = "nome", defaultValue = "Sem nome") String nome) {
        return nome;
    }

    @RequestMapping("endereco/{endereco}/{numero}")
    public String endereco(
            @PathVariable("endereco") String endereco, @PathVariable("numero") int numero) {
        return (endereco + " " + numero);
    }

    @RequestMapping ("/falha")
    public String falha(){
        throw new UnsupportedMathOperationException("falha na solicitação");

    }
}
