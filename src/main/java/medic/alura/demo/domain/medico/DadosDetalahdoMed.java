package medic.alura.demo.domain.medico;

import medic.alura.demo.domain.endereco.Endereco;

public record DadosDetalahdoMed(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalahdoMed(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getEspecialidade(),medico.getEndereco());
    }
}
