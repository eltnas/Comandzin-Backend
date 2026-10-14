package br.com.eltnas.comandzin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comandas")
public class Comandas {

    @Id
    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private boolean ativo = true;
}
