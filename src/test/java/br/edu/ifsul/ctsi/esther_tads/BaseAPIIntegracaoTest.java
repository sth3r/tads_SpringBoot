package br.edu.ifsul.ctsi.esther_tads;


import br.edu.ifsul.ctsi.esther_tads.autenticacao.AutenticacaoService;
import br.edu.ifsul.ctsi.esther_tads.infra.TokenService;
import br.edu.ifsul.ctsi.esther_tads.usuario.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.http.HttpMethod.*;

/*
    Esta é a superclasse para os testes dos controllers. Ela é baseada na classe TestRestTemplate (do Spring),
    que oferece ferramentas para chamadas HTTP em APIs reais. É por isso que a classe está marcada com
    @SpringBootTest e suas personalizações.
    Ela pode ser reutilizada para ralizar teste de integração de qualquer um dos controllers do proejto.
 */

@SpringBootTest(classes = EstherTadsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//indica que vai rodar o teste no container Spring Boot
public abstract class BaseAPIIntegracaoTest {
    @Autowired //indica ao Spring Boot que ele deve injetar essa dependência para a classe funcionar
    protected TestRestTemplate rest; //faz chamadas para APIs reais, no caso qualquer filha desta classe
    @Autowired //indica ao Spring Boot que ele deve injetar essa dependência para a classe funcionar
    private AutenticacaoService service;
    @Autowired //indica ao Spring Boot que ele deve injetar essa dependência para a classe funcionar
    private TokenService tokenService;

    private String jwtToken = "";


    //Metodo para logar um usuário e obter o token
    @BeforeEach //essa anotação faz com que o metodo seja executado antes dos demais, no setup
    public void setupTest() {
        // Le usuário
        Usuario user = (Usuario) service.loadUserByUsername("admin@email.com"); //note que os testes estão passando com o perfil "admin"
        assertNotNull(user);

        // Gera token
        jwtToken = tokenService.geraToken(user);
        assertNotNull(jwtToken);
    }

    //Metodo utilitário para montar o header da requisição
    protected HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwtToken);
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        return headers;
    }

    //Metodo genérico para requisições com o verbo POST
    protected <T> ResponseEntity<T> post(String url, Object body, Class<T> responseType) {
        HttpHeaders headers = getHeaders();

        return rest.exchange(url, POST, new HttpEntity<>(body, headers), responseType);
    }

    //Metodo genérico para requisições com o verbo PUT
    protected <T> ResponseEntity<T> put(String url, Object body, Class<T> responseType) {
        HttpHeaders headers = getHeaders();

        return rest.exchange(url, PUT, new HttpEntity<>(body, headers), responseType);
    }

    //Metodo generico para requisições com o verbo GET
    protected <T> ResponseEntity<T> get(String url, Class<T> responseType) {

        HttpHeaders headers = getHeaders();

        return rest.exchange(url, GET, new HttpEntity<>(headers), responseType);
    }

    //Metodo genérico para requisições com o verbo DELETE
    protected <T> ResponseEntity<T> delete(String url, Class<T> responseType) {

        HttpHeaders headers = getHeaders();

        return rest.exchange(url, DELETE, new HttpEntity<>(headers), responseType);
    }
}