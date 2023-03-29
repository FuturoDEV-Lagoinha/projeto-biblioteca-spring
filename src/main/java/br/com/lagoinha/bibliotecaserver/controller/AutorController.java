package br.com.lagoinha.bibliotecaserver.controller;

import br.com.lagoinha.bibliotecaserver.entity.Autor;
import br.com.lagoinha.bibliotecaserver.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<Autor> listar(){
        return autorService.listar();
    }

    @PostMapping
    public Autor salvar(@RequestBody Autor autor) {
        return this.autorService.salvar(autor);
    }

    @PutMapping("/{id}")
    public Autor atualizar(@PathVariable Long id,@RequestBody Autor autor) {
        return this.autorService.atualizar(id, autor);
    }
}
