package br.com.eltnas.comandzin.Login.auth;

import br.com.eltnas.comandzin.Login.LoginRequestDTO;
import br.com.eltnas.comandzin.Login.LoginResponseDTO;
import br.com.eltnas.comandzin.entities.Usuario;
import br.com.eltnas.comandzin.repository.UsuarioRepository;
import br.com.eltnas.comandzin.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AuthController {

    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto){
        Usuario usuario = repo.findByUsuario(dto.login())
                .orElse(null);

        if (usuario == null || !passwordEncoder.matches(dto.senha(), usuario.getSenha())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas!");
        }

        String token = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new LoginResponseDTO(
                token,
                usuario.getId(),
                usuario.getUsuario(),
                usuario.getNome(),
                usuario.getTipo()
        ));
    }
}