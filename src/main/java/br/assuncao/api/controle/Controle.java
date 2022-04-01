package br.assuncao.api.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.assuncao.api.modelo.Pessoa;

@RestController
public class Controle {
    
    @GetMapping("")
    public String mensagem(){
        return "APIs com Spring Boots!";
    }

    @GetMapping("/boas-vindas/")
    public String boasVindas(){
        return "Seja Bem vindo! ";
    }

    @GetMapping("/boas-vindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja Bem vindo! " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }
}
