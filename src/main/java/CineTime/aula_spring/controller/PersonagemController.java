package CineTime.aula_spring.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import CineTime.aula_spring.model.PersonagemDTO;

@RestController
@RequestMapping("/personagens-favoritos")
public class PersonagemController {
@GetMapping("/favoritos/{id}")
public ResponseEntity<PersonagemDTO> buscarPorId(@PathVariable Long id) {
    RestTemplate template = new RestTemplate();
    String url = "https://swapi.dev/api/people/" + id + "/";

    PersonagemDTO personagem = template.getForObject(url, PersonagemDTO.class);

    if (personagem == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(personagem);
    }
}
