package br.com.eltnas.comandzin.repository;

import br.com.eltnas.comandzin.entities.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
