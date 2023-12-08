package medic.alura.demo.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import medic.alura.demo.paciente.DadosAtualizaPaciente;
import medic.alura.demo.paciente.DadosListagemPaciente;
import medic.alura.demo.paciente.Paciente;
import medic.alura.demo.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    public PacienteRepository pacienteRepository;

    @PostMapping @Transactional
    public Paciente posta (@RequestBody Paciente dados){
        pacienteRepository.save(dados);
       return dados;
    }

    @GetMapping
    public Page<DadosListagemPaciente> listarP(Pageable pageable){
        return pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualiza(@RequestBody @Valid DadosAtualizaPaciente dadosAtualizaPaciente){
        pacienteRepository.getReferenceById(dadosAtualizaPaciente.id()).atualizaPaci(dadosAtualizaPaciente);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void deletar(@PathVariable Long id){
        pacienteRepository.getReferenceById(id).inativarPaciente();
    }

}
