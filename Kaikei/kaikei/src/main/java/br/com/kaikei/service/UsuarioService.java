package br.com.kaikei.service;

import br.com.kaikei.dto.UsuarioDTO;
import br.com.kaikei.model.Usuario;
import br.com.kaikei.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Esta classe fornece serviços relacionados à gestão de usuários.
 */
@AllArgsConstructor
@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    private JavaMailSender mailSender;

    /**
     * Recupera uma lista de todos os usuários.
     *
     * @return uma lista de objetos UsuarioDTO representando os usuários.
     */
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepository.buscarTodos().stream().map(UsuarioDTO::new).collect(Collectors.toList());
    }

    /**
     * Registra um novo usuário com o nome e e-mail fornecidos.
     *
     * @param nome      o nome do usuário.
     * @param email     o e-mail do usuário.
     * @return  Um String indicando o resultado da operação.
     *          Valores possíveis:
     *          -"erro: Já existe usuário com esse email" se um usuário com o mesmo e-mail já existir.
     *          -"scss: Sua senha para se logar foi enviada no e-mail" se o usuário foi registrado com sucesso.
      */
    public String cadastrarUsuario(String nome, String email){
        if (usuarioRepository.findByEmail(email).isPresent()){
            return "erro: Já existe usuário com esse email";
        }
        Usuario usuario = new Usuario(nome, email);
        String senha = usuario.geradorSenhaAleatoria();
        enviarEmail(senha, usuario.getEmail());
        usuarioRepository.save(usuario);
        return "scss: Sua senha para se logar foi enviada no email";
    }

    private void enviarEmail(String senha, String email) {

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("katol4571@gmail.com");
            message.setTo(email);
            message.setSubject("Sua senha para acessar a aplicação (Não responda)");
            message.setText("Abaixo senha para poder se logar na aplicação: \n" + senha);
            mailSender.send(message);

    }

    /**
     * Modifica o usuáiro com o ID especificado, atualizando seu nome e e-mail.
     *
     * @param id        o ID do usuário a ser modificado.
     * @param nome      o novo nome do usuário.
     * @param email     o novo e-mail do usuário.
     * @return          Um String indicando o resultado da operação.
     *                  Valor possível: "Usuário alterado com sucesso" se o usuário foi modificado com sucesso.
     */
    @Transactional
    public String alterar(Long id, String nome, String email){
        Usuario usuario = usuarioRepository.findById(id).get();
        if (!email.equals(usuario.getEmail())) {
            usuarioRepository.findByEmail(email);
        }
        usuario.setEmail(email);
        usuario.setNome(nome);
        usuarioRepository.save(usuario);
        return "Usuário alterado com sucesso";
    }

    /**
     * Recupera o usuário com o ID especificado.
     *
     * @param id o ID do usuário a ser recuperado.
     * @return   um objeto UsuarioDTO representando o usuário.
     */
    public UsuarioDTO buscarPorId(Long id) {
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }

    /**
     * Desativa o usuário com o ID especificado.
     *
     * @param id o ID do usuário a ser desativado.
     */
    public void desativarUsuario(Long id) {
        Usuario user = usuarioRepository.findById(id).get();
        user.setAtivo(false);
        usuarioRepository.save(user);
    }

    /**
     * Recupera o usuário com o e-mail especificado.
     *
     * @param email o e-mail do usuário a ser recuperado.
     * @return      um objeto Usuario representando o usuário.
     */
    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email).get();
    }
}
