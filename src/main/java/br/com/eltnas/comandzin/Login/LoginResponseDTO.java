package br.com.eltnas.comandzin.Login;

import br.com.eltnas.comandzin.entities.Tipo;

public record LoginResponseDTO(
        String token,
        Long id,
        String usuario,
        String nome,
        Tipo tipo
) {
}
