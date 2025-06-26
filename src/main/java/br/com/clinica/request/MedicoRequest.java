package br.com.clinica.request;

import br.com.clinica.model.Especialidade;
import br.com.clinica.model.Medico;
import br.com.clinica.model.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

        import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicoRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "CRM é obrigatório")
    private String crm;

    @NotNull(message = "Data de inscrição é obrigatória")
    private LocalDate dataInscricao;

    private Usuario usuario;

    private List<Especialidade> especialidades;

    public Medico build() {
        return Medico.builder()
                .nome(nome)
                .crm(crm)
                .dataInscricao(dataInscricao)
                .usuario(usuario)
                .especialidades(especialidades)
                .build();
    }
}