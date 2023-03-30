package br.com.lagoinha.bibliotecaserver.controller;

import br.com.lagoinha.bibliotecaserver.entity.Livro;
import br.com.lagoinha.bibliotecaserver.service.interfaces.LivroService;
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

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return this.livroService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        this.livroService.removerPorId(id);
    }
}
