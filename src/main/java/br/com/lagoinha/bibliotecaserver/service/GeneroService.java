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
        Genero generoPesquisado = buscarPorId(id);
        if(generoPesquisado != null) {
            generoPesquisado.setNome(generoAtualizado.getNome());
            return this.generoRepository.save(generoPesquisado);
        }
        return null;
    }

    public Genero buscarPorId(Long id) {
        Optional<Genero> generoPesquisado = this.generoRepository.findById(id);
        if(generoPesquisado.isPresent()) {
            return generoPesquisado.get();
        }
        return null;
    }

    public boolean removerPorId(Long id) {
        try {
            Genero generoPesquisado = buscarPorId(id);
            if (generoPesquisado == null) {
                return false;
            }
            this.generoRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
