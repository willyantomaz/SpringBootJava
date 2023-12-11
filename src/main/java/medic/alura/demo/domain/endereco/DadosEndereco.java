package medic.alura.demo.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public record DadosEndereco(

        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank@Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,
        @NotBlank
        String numero
) {

}
