package br.com.lagoinha.bibliotecaserver.service;

import br.com.lagoinha.bibliotecaserver.entity.Genero;
import br.com.lagoinha.bibliotecaserver.repository.GeneroRepository;
import jakarta.persistence.EntityExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> listar() {
        return this.generoRepository.findAll();
    }

    public Genero salvar(Genero genero){
        if(this.generoRepository.existsByNome(genero.getNome())){
            log.error("Gênero já existe");
            throw new EntityExistsException("Gênero já existente!");
        }
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
