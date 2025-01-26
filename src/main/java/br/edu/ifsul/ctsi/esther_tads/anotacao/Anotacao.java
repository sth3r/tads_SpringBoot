package br.edu.ifsul.ctsi.esther_tads.anotacao;

import br.edu.ifsul.ctsi.esther_tads.dia.Dia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity(name="Anotacao")
@Table(name = "anotacaos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Anotacao {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "dia_id", referencedColumnName = "id", nullable = false)
    private Dia dia;
}