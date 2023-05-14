package br.com.lagoinha.bibliotecaserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Editora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editora_id")
    private Long id;

    @Column (length = 20, nullable = false)
    private String nome;
<<<<<<< HEAD

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
=======
}
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
