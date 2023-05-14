package br.com.lagoinha.bibliotecaserver.controller;

import br.com.lagoinha.bibliotecaserver.entity.Editora;
import br.com.lagoinha.bibliotecaserver.entity.Genero;
import br.com.lagoinha.bibliotecaserver.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.stereotype.Controller;
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {
<<<<<<< HEAD

=======
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> listar() {
        return generoService.listar();
    }

    @GetMapping("/{id}")
    public Genero buscarPorId(@PathVariable Long id) {
        return this.generoService.buscarPorId(id);
    }

    @PostMapping
    public Genero salvar(@RequestBody Genero genero) {
        return this.generoService.salvar(genero);
    }

    @PutMapping
    public Genero atualizar(@PathVariable Long id, Genero genero) {
        return this.generoService.atualizar(id, genero);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return this.generoService.removerPorId(id);
    }

}
