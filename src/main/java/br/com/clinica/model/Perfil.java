package br.com.clinica.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "perfil")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public static final String ROLE_PACIENTE = "PACIENTE";
    public static final String ROLE_MEDICO = "MEDICO";
    public static final String ROLE_ADMIN = "ADMIN";

    @Override
    public String getAuthority() {
        return this.nome;
    }
}