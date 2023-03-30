package br.com.lagoinha.bibliotecaserver.controller;

import br.com.lagoinha.bibliotecaserver.entity.Editora;
import br.com.lagoinha.bibliotecaserver.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/editora")
public class EditoraController {
    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public List<Editora> listarEditora() {
        return editoraService.listarEditora();
    }

    @GetMapping("/{id}")
    public Editora buscarEditora(@PathVariable Long id){
        return this.editoraService.buscarEditora(id);
    }

    @PostMapping
    public Editora salvarEditora(@RequestBody Editora editora){
        return this.editoraService.salvarEditora(editora);
    }

    @PutMapping("/{id}")
    public Editora atualizarEditora(@PathVariable Long id, @RequestBody Editora editora){
        return this.editoraService.atualizarEditora(id, editora);
    }

}