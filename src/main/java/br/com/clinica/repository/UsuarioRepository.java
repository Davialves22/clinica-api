package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.clinica.model.*;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}