package br.edu.ifsul.ctsi.esther_tads.anotacao;

import br.edu.ifsul.ctsi.esther_tads.dia.DiaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/anotacaos")
public class AnotacaoController {

    private final AnotacaoRepository anotacaoRepository;
    private final DiaRepository diaRepository;

    public AnotacaoController(AnotacaoRepository anotacaoRepository, DiaRepository diaRepository) {
        this.anotacaoRepository = anotacaoRepository;
        this.diaRepository = diaRepository;
    }

    @GetMapping
    public ResponseEntity<List<AnotacaoDto>> findAll() {
        return ResponseEntity.ok(anotacaoRepository.findAll().stream().map(AnotacaoDto::new).toList());
    }

    @GetMapping("{id}") //URL_BASE:8080/api/v1/anotacaos/1
    public ResponseEntity<AnotacaoDto> findById(@PathVariable("id") Long id) {
        var optional = anotacaoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(new AnotacaoDto(optional.get()));
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<AnotacaoDto>> finByTitulo(@PathVariable("titulo") String titulo) {
        var anotacaos = anotacaoRepository.findByTitulo(titulo);
        return anotacaos.isEmpty() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.ok(anotacaos.stream().map(AnotacaoDto::new).toList());
    }

    @PostMapping
   // @Secured("ROLE_ADMIN")
    public ResponseEntity<URI> insert(@RequestBody AnotacaoDto anotacaoDto, UriComponentsBuilder uriBuilder) {
        var p = anotacaoRepository.save(new Anotacao(
                null,
                anotacaoDto.titulo(),
                anotacaoDto.conteudo(),
                diaRepository.findById(anotacaoDto.dia_id()).get()
        ));
        var location = uriBuilder.path("api/v1/anotacaos/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<AnotacaoDto> update(@PathVariable("id") Long id, @RequestBody AnotacaoDto anotacaoDto) {
        var optional = anotacaoRepository.findById(id);
        if (optional.isPresent()) {
            var p = anotacaoRepository.save(new Anotacao(
                    id,
                    anotacaoDto.titulo(),
                    anotacaoDto.conteudo(),
                    diaRepository.findById(anotacaoDto.dia_id()).get()
            ));
            return ResponseEntity.ok(new AnotacaoDto(p));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<AnotacaoDto> delete(@PathVariable("id") Long id) {
        var optional = anotacaoRepository.findById(id);
        if (optional.isPresent()) {
            anotacaoRepository.deleteById(id);
            return ResponseEntity.ok(new AnotacaoDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }
}