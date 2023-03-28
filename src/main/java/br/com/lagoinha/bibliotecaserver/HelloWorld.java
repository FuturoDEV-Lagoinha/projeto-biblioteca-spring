package br.com.lagoinha.bibliotecaserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping("/menssagem")
    public String hello() {
        return "Hello world!!!";
    }
}
