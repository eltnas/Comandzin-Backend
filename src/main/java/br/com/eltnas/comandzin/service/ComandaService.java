package br.com.eltnas.comandzin.service;

import br.com.eltnas.comandzin.entities.Comandas;
import br.com.eltnas.comandzin.repository.ComandasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComandaService {

    private final ComandasRepository repo;

    public ComandaService (ComandasRepository repo){
        this.repo = repo;
    }

    public Comandas salvarComandas(Comandas comandas) {
        return repo.save(comandas);
    }

    public List<Comandas> listarComandas(){
        return repo.findAll();
    }
}
