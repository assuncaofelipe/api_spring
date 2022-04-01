package br.assuncao.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.assuncao.api.modelo.Pessoa;
import br.assuncao.api.repositorio.Repositorio;

// RestController informa que é o controle de rotas
@RestController             
public class Controle {

    // atalho 
    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa objPessoa){
        return acao.save(objPessoa);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar(){
        return acao.findAll();
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo){
        return acao.findByCodigo(codigo);
    }

    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa objPessoa){
        return acao.save(objPessoa);
    }

    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable int codigo){
        Pessoa obj = selecionarPeloCodigo(codigo);

        acao.delete(obj);
    }
    
    // GetMap informa as rotas
    @GetMapping("")  
    public String mensagem(){
        return "APIs com Spring Boot!";
    }

    @GetMapping("/boas-vindas/")
    public String boasVindas(){
        return "Seja Bem vindo! ";
    }

    // PathVariable pode ser usada para manipular variáveis ​​de modelo no mapeamento 
    @GetMapping("/boas-vindas/{nome}")
    public String boasVindas(@PathVariable String nome){
        return "Seja Bem vindo! " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }
}
