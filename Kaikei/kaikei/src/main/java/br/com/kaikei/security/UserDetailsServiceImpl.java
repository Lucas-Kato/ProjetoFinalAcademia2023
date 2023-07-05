package br.com.kaikei.security;

import br.com.kaikei.model.Usuario;
import br.com.kaikei.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Implementação do serviço UserDetailService do Spring Security.
 * É responsável por carregar os detalhes do usuário com base no e-mail.
 */
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Carrega os detalhes do usuário com base no e-mail.
     *
     * @param email O e-mail do usuário.
     * @return  Um objeto userDetails contendo os detalhes do usuário.
     * @throws UsernameNotFoundException    Se o usuário não for encontrado.
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> userOptional = usuarioRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            Usuario usuario = userOptional.get();
            return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAtivo(),true, true, true, usuario.getPerfis());
        }
        return (UserDetails) new UsernameNotFoundException("Usuário não encontrado");
    }
}
