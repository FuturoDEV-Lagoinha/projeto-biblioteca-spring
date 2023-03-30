package br.com.lagoinha.bibliotecaserver.repository;

import br.com.lagoinha.bibliotecaserver.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
