package medic.alura.demo.domain.medico;

import jakarta.validation.constraints.NotNull;
import medic.alura.demo.domain.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        Boolean ativo,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco) {
}
