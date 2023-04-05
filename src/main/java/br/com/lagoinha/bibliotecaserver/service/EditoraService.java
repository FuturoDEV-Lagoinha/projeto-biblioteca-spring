package br.com.lagoinha.bibliotecaserver.service;

import br.com.lagoinha.bibliotecaserver.entity.Editora;
import br.com.lagoinha.bibliotecaserver.entity.Livro;
import br.com.lagoinha.bibliotecaserver.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepository;

    public List<Editora> listar() {
        //tras todos dados da tabela
        return this.editoraRepository.findAll();
    }

    public Editora salvar(Editora editora) {
        return this.editoraRepository.save(editora); //insert into editora (nome) values ('Mari')  (leva do back para o banco)

    }

    public Editora atualizar(Long id, Editora editoraAtualizada) {
        //vai buscar o id solicitado acima select * from editora where id = 1;
        Optional<Editora> editoraPesquisada = this.editoraRepository.findById(id);
        if (editoraPesquisada.isPresent()) {
            editoraPesquisada.get().setNome(editoraAtualizada.getNome());
            return this.editoraRepository.save(editoraPesquisada.get());//update
        }
        return null;
    }

    public Editora buscarPorId(Long id) {
        Optional<Editora> editoraPesquisada = this.editoraRepository.findById(id);
        if (editoraPesquisada.isPresent()) {
            editoraPesquisada.get();
            return editoraPesquisada.get();
        }
        return null;
    }

    public boolean removerPorId(Long id) {
        try {
            Editora editoraPesquisada = buscarPorId(id);
            if (editoraPesquisada == null) {
                return false;
            }
            this.editoraRepository.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
