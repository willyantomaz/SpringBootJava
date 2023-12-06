package medic.alura.demo.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import medic.alura.demo.Especialidade;
import medic.alura.demo.MedicoModel;
import medic.alura.demo.endereco.DadosEndereco;
import medic.alura.demo.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Medico(MedicoModel dados) {
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarInfo(DadosAtualizaMedico atualizaMedico) {
        if(atualizaMedico.nome() != null){
            this.nome = atualizaMedico.nome();
        }
        if (atualizaMedico.telefone() != null){
            this.telefone = atualizaMedico.telefone();
        }
        if(atualizaMedico.dadosEndereco() != null){
            this.endereco.atualizarEndereco(atualizaMedico.dadosEndereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
