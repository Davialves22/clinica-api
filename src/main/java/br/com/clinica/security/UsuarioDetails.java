package br.com.clinica.security;

import br.com.clinica.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetails implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioDetails(UsuarioRepository repo) {
        this.usuarioRepository = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

}