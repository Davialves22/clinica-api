package br.com.clinica.repository;

import br.com.clinica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Ex: buscar por nome ou CPF se quiser adicionar métodos customizados
}