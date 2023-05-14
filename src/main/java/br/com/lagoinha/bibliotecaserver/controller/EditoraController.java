package br.com.lagoinha.bibliotecaserver.controller;

import br.com.lagoinha.bibliotecaserver.entity.Editora;
import br.com.lagoinha.bibliotecaserver.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public Editora buscarEditora(@PathVariable Long id) {
        return this.editoraService.buscarPorId(id);
    }

    @PostMapping
    public Editora salvarEditora(@RequestBody Editora editora) {
        return this.editoraService.salvar(editora);
    }

    @PutMapping("/{id}")
    public Editora atualizarEditora(@PathVariable Long id, @RequestBody Editora editora) {
        return this.editoraService.atualizar(id, editora);
    }

    @DeleteMapping("/{id}")
<<<<<<< HEAD
    public boolean delete(@PathVariable Long id) {
        return this.editoraService.removerPorId(id);
    }

}
=======
    public void excluirEditora(@PathVariable Long id){
        this.editoraService.deleteById(id);
    }

}
>>>>>>> d66a2ea23cce4e34d45cc3c34667f447149d6928
