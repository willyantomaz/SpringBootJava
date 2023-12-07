package medic.alura.demo.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import medic.alura.demo.endereco.DadosEndereco;


public record PacienteModel(

        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank @Pattern(regexp = "\\d{11}")
        String cpf,

        @NotNull @Valid
        DadosEndereco endereco
) {
}
