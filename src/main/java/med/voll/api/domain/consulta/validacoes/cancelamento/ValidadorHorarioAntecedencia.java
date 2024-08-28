package med.voll.api.domain.consulta.validacoes.cancelamento;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioAntecedenciaCancelamento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosCancelamentoConsulta dados){
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        var dataConsulta = consulta.getData();
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, dataConsulta).toHours();
        if (diferencaEmHoras < 24) {
            throw new ValidationException("Consulta deve ser cancelada com antecedência de no mínimo 24 horas");
        }
    }
}
