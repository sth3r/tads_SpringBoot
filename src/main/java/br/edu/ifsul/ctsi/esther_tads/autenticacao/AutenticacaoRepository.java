package br.edu.ifsul.ctsi.esther_tads.autenticacao;

import br.edu.ifsul.ctsi.esther_tads.usuario.Usuario;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/*
    Esta interce visa, única e exclusivamente, realizar a busca pelo usuário com UserDetails.
    Note que ela implementa Repository, ao invés de JpaRepository. Assim, a AutenticacaoRepository
    vem vazia, sem métodos CRUD, como a JpaRepository. Logo, essa interface só terá o(s) método(s)
    implementado (s)nela.
    A responsabilidade por CRUD de usuários fica a cargo da UsuarioRepository.
 */
@RepositoryRestResource(exported = false)
public interface AutenticacaoRepository extends Repository<Usuario, Long> {
    Usuario findByEmail(String email);
}