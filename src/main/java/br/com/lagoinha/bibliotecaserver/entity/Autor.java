package br.com.lagoinha.bibliotecaserver.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private Long id;

    @Column(length = 20, nullable = false)
    private String nome;

    @Column(length = 40, nullable = false)
    private String sobrenome;

    private LocalDate nascimento;

    @ManyToMany
    private List<Livro> livros;
}
