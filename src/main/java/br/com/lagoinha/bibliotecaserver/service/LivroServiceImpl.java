package br.com.lagoinha.bibliotecaserver.service;

import br.com.lagoinha.bibliotecaserver.entity.Livro;
import br.com.lagoinha.bibliotecaserver.repository.LivroRepository;
import br.com.lagoinha.bibliotecaserver.service.interfaces.LivroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public Livro salvar(Livro livro) {
        return this.livroRepository.save(livro);
    }

    @Override
    public Livro atualizar(Livro livro) {
        Livro livroPesquisado = buscarPorId(livro.getId());

        if(livroPesquisado != null) {
            BeanUtils.copyProperties(livro,livroPesquisado,"id");
            return this.livroRepository.save(livroPesquisado);
        }
        return null;
    }

    @Override
    public Livro buscarPorId(Long id) {
        Optional<Livro> livroPesquisado = this.livroRepository.findById(id);

        if(livroPesquisado.isPresent()) {
            return livroPesquisado.get();
        }

        return null;
    }

    @Override
    public List<Livro> listar() {
        return this.livroRepository.findAll();
    }

    @Override
    public void removerPorId(Long id) {
        this.livroRepository.deleteById(id);
    }
}