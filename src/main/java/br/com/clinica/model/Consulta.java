package br.com.clinica.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "consultas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private String descricao;

    @ManyToOne @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}