package br.com.eltnas.comandzin.repository;

import br.com.eltnas.comandzin.entities.Comandas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComandasRepository extends JpaRepository<Comandas, Long> {
    List<Comandas> findByNumber(Integer number);
}
