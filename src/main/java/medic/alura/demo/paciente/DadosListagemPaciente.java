package medic.alura.demo.paciente;


public record DadosListagemPaciente(Long id,String nome, String cpf, String telefone, String email) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNome(), paciente.getCpf(),
                paciente.getTelefone(),
                paciente.getEmail());
    }
}
