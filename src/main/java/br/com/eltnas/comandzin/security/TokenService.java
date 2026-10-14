package br.com.eltnas.comandzin.security;

import br.com.eltnas.comandzin.entities.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class TokenService {

    @Value("${JWT_SECRET}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(usuario.getUsuario())
                .claim("id", usuario.getId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(key)
                .compact();
    }
}
