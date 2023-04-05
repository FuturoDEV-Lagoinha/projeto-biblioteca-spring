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
        return editoraService.listar();
    }

    @GetMapping("/{id}")
    public Editora buscarEditora(@PathVariable Long id){
        return this.editoraService.buscarPorId(id);
    }

    @PostMapping
    public Editora salvarEditora(@RequestBody Editora editora){
        return this.editoraService.salvar(editora);
    }

    @PutMapping("/{id}")
    public Editora atualizarEditora(@PathVariable Long id, @RequestBody Editora editora){
        return this.editoraService.atualizar(id, editora);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.editoraService.removerPorId(id);
    }

}
