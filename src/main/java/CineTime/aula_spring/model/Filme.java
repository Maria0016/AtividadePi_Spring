package CineTime.aula_spring.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan

public record Filme(
    String nome,
    Integer ano,
    String genero
){


}
    


