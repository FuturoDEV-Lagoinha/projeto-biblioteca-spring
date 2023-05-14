<<<<<<< HEAD
=======

>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
package br.com.lagoinha.bibliotecaserver.service.interfaces;

import br.com.lagoinha.bibliotecaserver.entity.Livro;

import java.util.List;

public interface LivroService {

    Livro salvar(Livro livro);
<<<<<<< HEAD

    Livro atualizar(Livro livro);

    Livro buscarPorId(Long id);

=======
    Livro atualizar(Livro livro);
    Livro buscarPorId(Long id);
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
    List<Livro> listar();

    List<Livro> buscarPorTitulo(String titulo);

    List<String> buscarPorQuantidade(Integer quantidadeExemplar);
<<<<<<< HEAD

    boolean removerPorId(Long id);

=======
    void removerPorId(Long id);
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
}
