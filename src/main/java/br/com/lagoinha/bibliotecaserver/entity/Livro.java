
package br.com.lagoinha.bibliotecaserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String titulo;

    @Column(length = 120)
    private String subTitulo;

    @Column(length = 10, nullable = false)
    private String idioma;

    @Column(length = 120, nullable = false)
    private String codigoIsbn;

    private Integer quantidadeExemplar;

    @ManyToOne
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany
    private List<Autor> autores;
}
