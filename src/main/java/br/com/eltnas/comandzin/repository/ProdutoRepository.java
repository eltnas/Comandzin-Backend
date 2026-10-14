package br.com.eltnas.comandzin.repository;

import br.com.eltnas.comandzin.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findBySetorId(Long setorId);
    List<Produto> findByDisponivelVendaTrue();
}
