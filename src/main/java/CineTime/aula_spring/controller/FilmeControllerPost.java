package CineTime.aula_spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import CineTime.aula_spring.model.Filme;

public class FilmeControllerPost {

     private List<Filme> listaFilmes = new ArrayList<>();

    @PostMapping
public ResponseEntity<?> adicionarFilme(
        @RequestBody Filme novoFilme) {

    if (novoFilme.nome() == null
            || novoFilme.nome().isBlank()) {
        return ResponseEntity.badRequest()
            .body(Map.of("erro", "Título é obrigatório"));
    }

    if (novoFilme.ano() == null
            || novoFilme.ano() < 1888
            || novoFilme.ano() > 2025) {
        return ResponseEntity
            .status(422)  // Unprocessable Entity — dados ok, regra de negócio falhou
            .body(Map.of("erro", "Ano deve estar entre 1888 e 2025"));
    }

    boolean duplicado = listaFilmes.stream()
        .anyMatch(f -> f.nome().equalsIgnoreCase(novoFilme.nome()));
    if (duplicado) {
        return ResponseEntity
            .status(409)  // Conflict — recurso já existe
            .body(Map.of("erro", "Filme já existe na lista"));
    }

    listaFilmes.add(novoFilme);

    return ResponseEntity
        .status(201)
        .body(Map.of(
            "mensagem", "Filme adicionado com sucesso",
            "filme", novoFilme
        ));
    }
}
