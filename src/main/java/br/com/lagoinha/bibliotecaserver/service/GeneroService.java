package br.com.lagoinha.bibliotecaserver.service;

import br.com.lagoinha.bibliotecaserver.entity.Genero;
import br.com.lagoinha.bibliotecaserver.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> listar() {
        return this.generoRepository.findAll();
    }

    public Genero salvar(Genero genero){
        return this.generoRepository.save(genero);
    }

    public Genero atualizar(Long id, Genero generoAtualizado) {
        Optional<Genero> generoPesquisado = this.generoRepository.findById(id);
        if(generoPesquisado.isPresent()) {
            generoPesquisado.get().setNome(generoAtualizado.getNome());
            return this.generoRepository.save(generoPesquisado.get());
        }
        return null;
    }
}
