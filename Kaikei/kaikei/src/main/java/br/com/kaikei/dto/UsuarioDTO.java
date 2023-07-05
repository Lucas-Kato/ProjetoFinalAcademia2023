package br.com.kaikei.dto;

import br.com.kaikei.model.Usuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;

    /**
     * Construtor vazio da classe UsuarioDTO.
     */
    public UsuarioDTO() {
    }

    /**
     * Construtor da classe UsuarioDTO.
     *
     * @param usuario  o usuário a ser mapeado para o DTO.
     */
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
