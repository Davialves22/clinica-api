package br.com.clinica.repository;

import br.com.clinica.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    List<Consulta> findByDataConsulta(LocalDate dataConsulta);

    // Exemplo extra: listar por médico
    List<Consulta> findByMedicoId(Long medicoId);

    // Exemplo extra: listar por paciente
    List<Consulta> findByPacienteId(Long pacienteId);
}