package br.com.lagoinha.bibliotecaserver.service.interfaces;

import br.com.lagoinha.bibliotecaserver.entity.Livro;

import java.util.List;

public interface LivroService {

    Livro salvar(Livro livro);

    Livro atualizar(Livro livro);

    Livro buscarPorId(Long id);

    List<Livro> listar();

    List<Livro> buscarPorTitulo(String titulo);

    List<String> buscarPorQuantidade(Integer quantidadeExemplar);

    void removerPorId(Long id);

}
