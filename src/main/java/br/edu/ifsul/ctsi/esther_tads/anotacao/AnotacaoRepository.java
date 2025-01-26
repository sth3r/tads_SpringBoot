package br.edu.ifsul.ctsi.esther_tads.anotacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
    List<Anotacao> findByTitulo(String titulo);

}