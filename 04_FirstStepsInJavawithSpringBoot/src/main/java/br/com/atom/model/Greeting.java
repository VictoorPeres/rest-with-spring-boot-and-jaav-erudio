package br.com.atom.model;

//uma record é uma forma moderna e concisa de declarar uma classe imutável usada geralmente para representar dados — como DTOs, respostas de API, ou entidades simples.
public record Greeting(Long id, String content) {
    
}
