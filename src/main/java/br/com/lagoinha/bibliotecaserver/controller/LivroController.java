package br.com.lagoinha.bibliotecaserver.controller;

import br.com.lagoinha.bibliotecaserver.entity.Livro;
import br.com.lagoinha.bibliotecaserver.service.interfaces.LivroService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public Livro salvar(@RequestBody Livro livro) {

        return this.livroService.salvar(livro);
    }

    @PutMapping
    public Livro atualizar(@RequestBody Livro livro) {
        return this.livroService.atualizar(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return this.livroService.listar();
    }

    @GetMapping("/buscar-por-titulo")
    public List<Livro> buscarPorTitulo(@PathParam("titulo") String titulo) {
        return this.livroService.buscarPorTitulo(titulo);
    }

    @GetMapping("/buscar-por-quantidade")
    public List<String> buscarPorQuantidade(@PathParam("quantidadeExemplar") Integer quantidadeExemplar) {
        return this.livroService.buscarPorQuantidade(quantidadeExemplar);
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return this.livroService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.livroService.removerPorId(id);
    }
}
