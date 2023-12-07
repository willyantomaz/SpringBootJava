package medic.alura.demo.controller;

import jakarta.transaction.Transactional;
import medic.alura.demo.paciente.PacienteModel;
import medic.alura.demo.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    public PacienteRepository pacienteRepository;

    @PostMapping @Transactional
    public void paciente (@RequestBody PacienteModel dados){
        System.out.println("postado"+dados);
    }
}
