package br.com.lagoinha.bibliotecaserver.repository;

import br.com.lagoinha.bibliotecaserver.entity.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {

}