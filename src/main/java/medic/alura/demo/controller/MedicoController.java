package medic.alura.demo.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medic.alura.demo.MedicoModel;
import medic.alura.demo.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity medicoPost(@RequestBody @Valid MedicoModel dados, UriComponentsBuilder uriComponentsBuilder){
     var medico = new Medico(dados);
     repository.save(medico);

     var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

     return ResponseEntity.created(uri).body(new DadosDetalahdoMed(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(sort = {"nome"}) Pageable pageable){
        var page = repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualiza(@RequestBody @Valid DadosAtualizaMedico atualizaMedico){
        var medico = repository.getReferenceById(atualizaMedico.id());
        medico.atualizarInfo(atualizaMedico);

        return ResponseEntity.ok(new DadosDetalahdoMed(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }


}
