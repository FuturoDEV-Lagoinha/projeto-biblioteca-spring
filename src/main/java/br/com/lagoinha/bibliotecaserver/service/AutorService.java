package br.com.lagoinha.bibliotecaserver.service;

import br.com.lagoinha.bibliotecaserver.entity.Autor;
import br.com.lagoinha.bibliotecaserver.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listar() {
        return this.autorRepository.findAll();
    }

    public Autor salvar(Autor autor) {
        //insert into autor (nome) values ('André Gustavo');
        return this.autorRepository.save(autor);
    }
}
