package medic.alura.demo.medico;

import medic.alura.demo.endereco.Endereco;

public record DadosDetalahdoMed(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalahdoMed(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(),medico.getEspecialidade(),medico.getEndereco());
    }
}
