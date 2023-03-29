package br.com.lagoinha.bibliotecaserver.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(length = 40, nullable = false)
    private String sobreNome;

    private LocalDate nascimento;
}
