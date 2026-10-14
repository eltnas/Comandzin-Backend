package br.com.eltnas.comandzin.service;

import br.com.eltnas.comandzin.entities.Usuario;
import br.com.eltnas.comandzin.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
        this.repo = repo;
    }

    public Usuario salvar(Usuario usuario){

        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        return repo.save(usuario);
    }

    public List<Usuario> listarTodos(){
        return repo.findAll();
    }

    public Usuario listarPorId(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public void excluir(Long id){
        if(!repo.existsById(id)){
            throw new RuntimeException("Usuário não encontrado!");
        }

        repo.deleteById(id);
    }

}
