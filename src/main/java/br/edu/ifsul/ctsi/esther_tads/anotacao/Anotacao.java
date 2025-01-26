package br.edu.ifsul.ctsi.esther_tads.anotacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Anotacao {
    @Id @GeneratedValue
    private Long id;
    private String titulo;
    private String conteudo;
}




