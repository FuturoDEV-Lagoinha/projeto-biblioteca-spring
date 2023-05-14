<<<<<<< HEAD
=======

>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
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
    @Column(name = "livro_id")
    private Long id;

    @Column(length = 120, nullable = false)
    private String titulo;

    @Column(length = 120)
    private String subtitulo;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Genero genero;

    @Column(length = 10, nullable = false)
    private String idioma;

    @Column(length = 100, nullable = false)
    private String codigoIsbn;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "editora_id", nullable = false)
    private Editora editora;

    private Integer qtdExemplar;

=======
    private Integer quantidadeExemplar;

    @ManyToOne
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "editora_id")
    private Editora editora;

    @ManyToMany
    private List<Autor> autores;
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
}
