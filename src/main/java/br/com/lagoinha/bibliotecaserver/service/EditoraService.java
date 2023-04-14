package br.com.lagoinha.bibliotecaserver.service;

import br.com.lagoinha.bibliotecaserver.entity.Editora;
import br.com.lagoinha.bibliotecaserver.repository.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;
    public List<Editora> listarEditora(){
        //tras todos dados da tabela
        return this.editoraRepository.findAll();
    }

    public Editora salvarEditora(Editora editora){
        return this.editoraRepository.save(editora); //insert into editora (nome) values ('Mari')  (leva do back para o banco)

    }

    public Editora atualizarEditora(Long id, Editora editoraAtualizada){
        //vai buscar o id solicitado acima select * from editora where id = 1;
        Optional<Editora> editoraPesquisada = this.editoraRepository.findById(id);
        if(editoraPesquisada.isPresent()){
            editoraPesquisada.get().setNome(editoraAtualizada.getNome());
            return this.editoraRepository.save(editoraPesquisada.get());//update
        }
        return null;
    }

    public Editora buscarEditora(Long id) {
        if(id == null){
            log.warn("O ID informado está nulo");
            return null;
        }
        Optional<Editora> editoraPesquisada = this.editoraRepository.findById(id);
        if(editoraPesquisada.isPresent()){
            return editoraPesquisada.get();
        } else {
            String mensagem = "Não foi possível encontrar uma editora com o id: " + id;
            log.error(mensagem);
            throw new EntityNotFoundException(mensagem);
        }
    }

    public void deleteById(Long id) {
        id = 100l;
        this.editoraRepository.deleteById(id);
    }
}