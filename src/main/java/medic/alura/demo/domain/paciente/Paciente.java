package medic.alura.demo.domain.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import medic.alura.demo.domain.endereco.Endereco;


@Table(name = "pacientes")
@Entity(name = "Paciente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@EqualsAndHashCode(of = "id")

public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Email
    private String email;
    @NotBlank
    private String telefone;
    @NotBlank @Pattern(regexp = "\\d{11}")
    private String cpf;

    @Embedded @NotNull @Valid
    private Endereco endereco;
    private boolean ativo = true;

    public Paciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNome(), paciente.getCpf(),
                paciente.getTelefone(),
                paciente.getEmail(),paciente.getEndereco(),paciente.isAtivo());
    }

    public void atualizaPaci(DadosAtualizaPaciente atualizaPaciente){
        if(atualizaPaciente.nome() != null){
            this.nome = atualizaPaciente.nome();
        }
        if(atualizaPaciente.ativo() != null){
            this.ativo = atualizaPaciente.ativo();
        }
        if(atualizaPaciente.email() != null){
            this.email = atualizaPaciente.email();
        }
        if(atualizaPaciente.telefone() != null){
            this.telefone = atualizaPaciente.telefone();
        }
        if(atualizaPaciente.cpf() != null){
            this.cpf = atualizaPaciente.cpf();
        }
        if(atualizaPaciente.dadosEndereco() != null){
            this.endereco.atualizarEndereco(atualizaPaciente.dadosEndereco());
        }
    }

    public void inativarPaciente(){
        this.ativo = false;
    }

}
