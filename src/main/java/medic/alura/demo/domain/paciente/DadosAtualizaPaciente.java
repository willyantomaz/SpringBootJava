package medic.alura.demo.domain.paciente;

import jakarta.validation.constraints.NotNull;
import medic.alura.demo.domain.endereco.DadosEndereco;


public record DadosAtualizaPaciente(
        @NotNull
        Long id,
        Boolean ativo,
        String nome,
        String cpf,
        String email,
        String telefone,
        DadosEndereco dadosEndereco) {
}
