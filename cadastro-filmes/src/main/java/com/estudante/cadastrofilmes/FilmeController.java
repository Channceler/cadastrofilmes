package com.estudante.cadastrofilmes;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> listaFilmes = new ArrayList<>();

    public FilmeController() {
        // Pré-cadastrando 3 filmes diretamente no construtor
        listaFilmes.add(new Filme(1L, "De Volta para o Futuro", "Ficção Científica", 1985));
        listaFilmes.add(new Filme(2L, "O Senhor dos Anéis: A Sociedade do Anel", "Fantasia", 2001));
        listaFilmes.add(new Filme(3L, "Matrix", "Ação/Ficção Científica", 1999));
    }

    // Endpoint para listar todos os filmes
    @GetMapping
    public List<Filme> listarTodos() {
        return listaFilmes;
    }

    // Endpoint para cadastrar um novo filme
    @PostMapping
    public String cadastrar(@RequestBody Filme filme) {
        listaFilmes.add(filme);
        return "Filme '" + filme.getTitulo() + "' cadastrado com sucesso!";
    }
}