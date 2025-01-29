package br.edu.ifsul.ctsi.esther_tads.anotacao;

import br.edu.ifsul.ctsi.esther_tads.BaseAPIIntegracaoTest;
import br.edu.ifsul.ctsi.esther_tads.EstherTadsApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = EstherTadsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//carrega o Context do app em um container Spring Boot com um servidor web
@ActiveProfiles("test") //indica o profile que o Spring Boot deve utilizar para passar os testes
class AnotacaoControllerIntegracaoTest extends BaseAPIIntegracaoTest {

    //Metodos utilitários (eles encapsulam o TestRestTemplate e eliminam a repetição de código nos casos de teste)
    private ResponseEntity<AnotacaoDto> getAnotacao(String url) {
        return get(url, AnotacaoDto.class);
    }

    private ResponseEntity<List<AnotacaoDto>> getAnotacaosList(String url) {
        var headers = getHeaders();

        return rest.exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                new ParameterizedTypeReference<>() {
                });
    }

    @Test
    @DisplayName("Espera uma lista com 5 objetos")
    void findAll() {
        //ACT
        var anotacaos = getAnotacaosList("/api/v1/anotacaos").getBody();

        //ASSERT
        assertNotNull(anotacaos);
        assertEquals(4, anotacaos.size());
    }

    @Test
    void findById() {
        // ARRANGE
        var id = 2;
        var url = "/api/v1/anotacaos/" + id;

        // ACT
        var anotacao = getAnotacao(url).getBody();

        // ASSERT
        assertNotNull(anotacao);
        assertEquals("lista de comprsa", anotacao.titulo());
    }

    @Test
    void findByTitulo() {
    }

    @Test
    void insert() {
//        // ARRANGE
//        var AnotacaoDto = new AnotacaoDto(
//                "Teste",
//                "vai sre excluido"
//        );
//
//        // ACT
//        var response = post("/api/v1/produtos", AnotacaoDto, null);
//
//        // ASSERT
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//        var location = response.getHeaders().get("location").get(0);
//        var p = getAnotacao(location).getBody();
//        assertNotNull(p);
//        assertEquals("Teste", p.titulo());
//        assertEquals("vai sre excluido", p.conteudo());
//
//        // ACT
//        delete(location, null);
//
//        // ASSERT
//        assertEquals(HttpStatus.NOT_FOUND, getAnotacao(location).getStatusCode());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
//        // ARRANGE
//        var anotacao = new Anotacao();
//        anotacao.setTitulo("Teste");
//        anotacao.setConteudo("Desc. do produto Teste");
//
//        var responsePost = post("/api/v1/anotacaos", anotacao, null);
//        assertEquals(HttpStatus.CREATED, responsePost.getStatusCode());
//        var location = responsePost.getHeaders().get("location").get(0);
//        var p = getAnotacao(location).getBody();
//        assertNotNull(p);
//        assertEquals("Teste", p.titulo());
////        assertEquals(Integer.valueOf(100), p.estoque());
//
//        // ACT
//        var responseDelete = delete(location, null);
//
//        // ASSERT
//        assertEquals(HttpStatus.OK, responseDelete.getStatusCode());
//        assertEquals(HttpStatus.NOT_FOUND, getAnotacao(location).getStatusCode());
    }
}