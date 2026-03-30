package CineTime.aula_spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CineTime.aula_spring.model.Filme;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> listaFilmes = new ArrayList<>(Arrays.asList(
        new Filme("Interestelar", 2014, "Ficção Científica"),
        new Filme("O Poderoso Chefão", 1972, "Drama")
    ));

    @GetMapping
    public List<Filme> listarTodos() {
        return listaFilmes;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable Long id){
         if (id == null || id < 0) {
        return ResponseEntity.badRequest().build();
    }
    int indice = id.intValue();
    if (indice >= listaFilmes.size()) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity
        .ok()
        .header("X-Total-Filmes", String.valueOf(listaFilmes.size()))
        .body(listaFilmes.get(indice));
}
       
}


