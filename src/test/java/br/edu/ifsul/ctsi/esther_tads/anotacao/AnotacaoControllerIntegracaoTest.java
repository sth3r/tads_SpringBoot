package br.edu.ifsul.ctsi.esther_tads.anotacao;

import br.edu.ifsul.ctsi.esther_tads.BaseAPIIntegracaoTest;
import br.edu.ifsul.ctsi.esther_tads.EstherTadsApplication;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
        assertEquals(5, anotacaos.size());
    }

    @Test
    void findById() {
    }

    @Test
    void finByNome() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}