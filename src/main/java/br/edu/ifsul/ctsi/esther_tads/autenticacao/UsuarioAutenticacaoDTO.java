package br.edu.ifsul.ctsi.esther_tads.autenticacao;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioAutenticacaoDTO(
        @Email @NotBlank
        String email,
        @NotBlank
        String senha) {
}