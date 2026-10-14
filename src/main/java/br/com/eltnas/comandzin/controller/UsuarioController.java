package br.com.eltnas.comandzin.controller;

import br.com.eltnas.comandzin.entities.Usuario;
import br.com.eltnas.comandzin.service.UsuarioService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        Usuario newUser = service.salvar(usuario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }

    // Read
    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.listarPorId(id));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualiza(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario existente = service.listarPorId(id);

        existente.setNome(usuario.getNome());
        existente.setSenha(usuario.getSenha());

        Usuario atualizado = service.salvar(existente);
        return ResponseEntity.ok(atualizado);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}
