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
<<<<<<< HEAD

=======
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
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
        Genero generoPesquisado = buscarPorId(id);
        if(generoPesquisado != null) {
            generoPesquisado.setNome(generoAtualizado.getNome());
            return this.generoRepository.save(generoPesquisado);
        }
        return null;
    }
<<<<<<< HEAD

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

=======
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
}
