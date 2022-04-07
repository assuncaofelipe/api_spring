package br.assuncao.api.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.assuncao.api.modelo.Pessoa;
import br.assuncao.api.repositorio.Repositorio;
import br.assuncao.api.servico.Servico;

// RestController informa que é o controle de rotas
@RestController             
public class Controle {

    // atalho 
    @Autowired
    private Repositorio acao;

    @Autowired
    private Servico servico;

    // GetMap informa as rotas e da boas vindas
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

    // CRIA UMA ROTA DE PESSOAS
    // Vincula modelos e controles da classe Pessoa.java
    // REALIZA O POST COM OS DADOS DA CLASSE MODELO
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa pessoa) {
        return pessoa;
    }

    // REALIZA OPERACOES DO CRUD
    // CADASTRAR
    @PostMapping("/api")
    public ResponseEntity<?> cadastrar(@RequestBody Pessoa obj){
        return servico.cadastrar(obj);
    }

    // EDITAR
    @PutMapping("/api")
    public ResponseEntity<?> editar(@RequestBody Pessoa obj){
        return servico.editar(obj);
    }

    // DELETA CADASTRADO PELO CODIGO
    @DeleteMapping("/api/{codigo}")
    public ResponseEntity<?> remover(@PathVariable int codigo){
        return servico.remover(codigo);
    }

    // SELECIONAR
    @GetMapping("/api")
    public ResponseEntity<?> selecionar(){
        return servico.selecionar();
    }

    // SELECIONAR PELO CODIGO
    @GetMapping("/api/{codigo}")
    public ResponseEntity<?> selecionarPeloCodigo(@PathVariable int codigo){
        return servico.selecionarPeloCodigo(codigo);
    }
    
    // CONTA A QTD DE CADASTRADOS NO BD
    @GetMapping("/api/contador")
    public long contador(){
        return acao.count();
    }

    // ORDENA PELO NOME EM Desc
    @GetMapping("/api/ordenarNomes")
    public List<Pessoa> ordenarNomes(){
        return acao.findByOrderByNomeDesc();
    }

    // ORDENA PELA IDADE EM Desc
    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdadeDesc("Thiago");
    }

    // VERIFICA QUAIS NOMES TEM A LETRA i
    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("i");
    }

    // VERIFICA QUAIS NOMES INICIA COM A LETRA a - ou qualquer letra que tu mudar
    @GetMapping("/api/iniciaCom")
    public List<Pessoa> iniciaCom(){
        return acao.findByNomeStartsWith("a");
    }

    // VERIFICA QUAIS NOMES TERMINA COM A LETRA o - ou qualquer letra que tu mudar
    @GetMapping("/api/terminaCom")
    public List<Pessoa> terminaCom(){
        return acao.findByNomeEndsWith("O");
    }

    // SOMA TODAS AS IDADES
    @GetMapping("/api/somaIdades")
    public int somaIdades(){
        return acao.somaIdades();
    }

    // VERIFICA QUAIS IDADES SAO MAIORES QUE 18
    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual(){
        return acao.idadeMaiorIgual(18);
    }

    // altera os status
    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
