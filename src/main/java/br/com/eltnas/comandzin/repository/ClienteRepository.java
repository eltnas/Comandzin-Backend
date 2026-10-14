package br.com.eltnas.comandzin.repository;

import br.com.eltnas.comandzin.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
