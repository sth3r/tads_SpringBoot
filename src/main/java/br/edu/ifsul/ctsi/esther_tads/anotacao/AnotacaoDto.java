package br.edu.ifsul.ctsi.esther_tads.anotacao;

import java.io.Serializable;

public record AnotacaoDto(
        String titulo,
        String conteudo,
        Long dia_id)  implements Serializable {
    public AnotacaoDto(Anotacao anotacao) {
        this(anotacao.getTitulo(), anotacao.getConteudo(), anotacao.getId());
    }
}