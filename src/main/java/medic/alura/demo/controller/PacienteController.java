package medic.alura.demo.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medic.alura.demo.domain.paciente.DadosAtualizaPaciente;
import medic.alura.demo.domain.paciente.DadosListagemPaciente;
import medic.alura.demo.domain.paciente.Paciente;
import medic.alura.demo.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;




@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    public PacienteRepository pacienteRepository;

    @PostMapping @Transactional
    public ResponseEntity posta (@RequestBody Paciente dados, UriComponentsBuilder uriComponentsBuilder){
        var paciente = new Paciente();
        paciente = pacienteRepository.save(dados);


        var uri = uriComponentsBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemPaciente(paciente));

    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listarP(Pageable pageable){
        var page = pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id){
        var paciente = pacienteRepository.getReferenceById(id);
        return ResponseEntity.ok(new Paciente(paciente));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualiza(@RequestBody @Valid DadosAtualizaPaciente dadosAtualizaPaciente){
        var paciente = pacienteRepository.getReferenceById(dadosAtualizaPaciente.id());
        paciente.atualizaPaci(dadosAtualizaPaciente);
        return ResponseEntity.ok(new DadosListagemPaciente(paciente));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        pacienteRepository.getReferenceById(id).inativarPaciente();

        return ResponseEntity.noContent().build();
    }

}
