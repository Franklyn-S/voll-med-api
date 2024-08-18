package med.voll.api.domain.medico;


public record DadosListagemMedico(Long id,
                                  String nome,
                                  String email,
                                  String CRM,
                                  String especialidade
//                        String telefone,
//                        String endereco
) {

    public DadosListagemMedico(Medico m) {
        this(
               m.getId(),  m.getNome(), m.getEmail(), m.getCrm(), m.getEspecialidade().name()
//                , m.getTelefone(), m.getEndereco().toString()
        );
    }
}
