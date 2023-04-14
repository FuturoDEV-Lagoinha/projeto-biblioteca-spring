package br.com.lagoinha.bibliotecaserver.service;

import br.com.lagoinha.bibliotecaserver.entity.Autor;
import br.com.lagoinha.bibliotecaserver.repository.AutorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listar() {
        //select id, name from autor
        return this.autorRepository.findAll();
    }

    public Autor salvar(Autor autor) {
        //insert into autor (nome) values ('André Gustavo');
        return this.autorRepository.save(autor);
    }

    public Autor buscaPorId(Long id) {
        //select id, nome form autor where id = id
        Optional<Autor> autorPesquisado = this.autorRepository.findById(id);
        if(autorPesquisado.isPresent()){
            return autorPesquisado.get();
        }else {
            return null;
        }
    }

    public Autor atualizar(Long id, Autor autorAtualizado) {
        //select * from autor where id = 1;
        Autor autorPesquisado = buscaPorId(id);

        if (autorPesquisado != null) {
            autorPesquisado.setNome(autorAtualizado.getNome());
            autorPesquisado.setSobrenome(autorAtualizado.getSobrenome());
            autorPesquisado.setNascimento(autorAtualizado.getNascimento());
            log.info("Atualizando autor...");
            return this.autorRepository.save(autorPesquisado);
        }
        return null;
    }
    public void deleteById(Long id) {
        try {
            this.autorRepository.deleteById(id);
        } catch (Exception e){
            log.error("Impossível remoção!");
        }


    }
}
