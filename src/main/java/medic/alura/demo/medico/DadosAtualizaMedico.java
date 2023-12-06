package medic.alura.demo.medico;

import jakarta.validation.constraints.NotNull;
import medic.alura.demo.endereco.DadosEndereco;

public record DadosAtualizaMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco) {
}
