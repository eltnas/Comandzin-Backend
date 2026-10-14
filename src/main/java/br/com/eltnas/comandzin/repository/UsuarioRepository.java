package br.com.eltnas.comandzin.repository;

import br.com.eltnas.comandzin.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String usuario);
}
