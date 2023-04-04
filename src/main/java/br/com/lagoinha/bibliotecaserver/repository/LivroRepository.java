package br.com.lagoinha.bibliotecaserver.repository;

import br.com.lagoinha.bibliotecaserver.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTitulo(String titulo); //select * from livro where titulo = titulo que está passando aqui

    @Query(value = "select titulo from livro where quantidade_exemplar = :quantidade", nativeQuery = true)
    List<String> buscarPorQuantidadeExemplar(@Param("quantidade") Integer quantidadeExemplar);

    Boolean existsByTituloAndIdioma(String titulo, String idioma);
}
