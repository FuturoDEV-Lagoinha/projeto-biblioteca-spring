package br.com.lagoinha.bibliotecaserver.service;

import br.com.lagoinha.bibliotecaserver.entity.Autor;
import br.com.lagoinha.bibliotecaserver.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Autor atualizar(Long id, Autor autorAtualizado) {
        //select * from autor where id = 1;
        Optional<Autor> autorPesquisado = this.autorRepository.findById(id);

        if (autorPesquisado.isPresent()) {
            autorPesquisado.get().setNome(autorAtualizado.getNome());
            autorPesquisado.get().setSobreNome(autorAtualizado.getSobreNome());
            autorPesquisado.get().setNascimento(autorAtualizado.getNascimento());
            return this.autorRepository.save(autorPesquisado.get());
        }

        return null;
    }
}
