package medic.alura.demo.paciente;

import jakarta.validation.constraints.NotNull;
import medic.alura.demo.endereco.DadosEndereco;


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
