package br.com.atom.controller;

import br.com.atom.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

//A anotação @RestController no Spring Boot é usada para indicar que uma classe Java vai tratar requisições HTTP e devolver respostas diretamente no corpo da resposta (JSON, XML, etc.), sem renderizar páginas HTML como faria um @Controller.
@RestController
public class GreetingController {

    //é uma template string, onde %s será substituído por algum valor
    private static final String template = "Hello, %s!";

    //Criar um contador seguro para ambientes com múltiplas threads.
    //Muito comum em exemplos de APIs REST para simular um ID incremental de um objeto.
    private final AtomicLong counter = new AtomicLong();

    //A anotação @RequestMapping no Spring é usada para mapear requisições HTTP (como GET, POST, PUT, DELETE) para métodos de uma classe controladora.
    @RequestMapping("/greeting")
    //O método greeting() deve retornar um objeto Greeting, que é uma record definida na classe
    //Exemplo com queryParam http://localhost:8080/greeting?name=Atom
    public Greeting greeting(@RequestParam(name = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
