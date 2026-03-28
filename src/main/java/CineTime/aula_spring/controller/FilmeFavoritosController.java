package CineTime.aula_spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/filmes-favoritos")
public class FilmeFavoritosController {
    @GetMapping
    public ResponseEntity<String> buscarFilmeFavorito() {
        RestTemplate template = new RestTemplate();

        String url = "https://swapi.dev/api/people/1/";

        String resposta = template.getForObject(url, String.class);

        return ResponseEntity.ok(resposta);
    }
}
