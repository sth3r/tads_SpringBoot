package br.edu.ifsul.ctsi.esther_tads.dia;

import br.edu.ifsul.ctsi.esther_tads.usuario.Usuario;
import br.edu.ifsul.ctsi.esther_tads.anotacao.Anotacao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Collection;

@Entity(name = "Dia")
@Table(name = "dias")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Dia {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;
    @OneToMany(mappedBy = "dia", fetch = FetchType.EAGER)
    private Collection<Anotacao> anotacaos;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;
}