package br.com.kaikei.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Representa uma usuário no sistema.
 */
@Getter
@Setter
@Entity
public class Usuario implements UserDetails {
    /**
     * Identificador único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nome do usuário.
     */
    private String nome;
    /**
     * E-mail do usuáiro.
     */
    private String email;
    /**
     * Senha do usário.
     */
    private String senha;
    /**
     * Indica se o usuário está ativo.
     */
    private Boolean ativo;
    /**
     * Lista de perfis assossiados ao usuário.
     */
    @ManyToMany
    @JoinTable(name = "tb_Usuarios_perfis",
    joinColumns = @JoinColumn(name = "id_usuarios"),
    inverseJoinColumns = @JoinColumn(name = "id_perfis"))
    private List<Perfil> perfis = new ArrayList<>();

    /**
     * Contrutor vazio da classe Usuario.
     */
    public Usuario() {
    }

    /**
     * Constrói uma nova instância da classe Usuario com os detalhes específicos.
     *
     * @param nome  O nome do usuário.
     * @param email O e-mail do usuário;
     */
    public Usuario(String nome, String email) {
        this.nome  = nome;
        this.email = email;
        this.ativo = true;
    }

    /**
     * Gera uma senha aleatório para o usuáiro.
     *
     * @return  A senha aleatória gerada.
     */
    public String geradorSenhaAleatoria() {
        String letter = "abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIJKLMNOPRSTUVWXYZ@-&_?";
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder senha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            senha.append(letter.charAt(secureRandom.nextInt(letter.length())));
        }
        setSenha(senha.toString());
        return senha.toString();
    }

    /**
     * Define a senha do usuário.
     *
     * @param senha A senha do usuário.
     */
    public void setSenha(String senha) {
        this.senha = new BCryptPasswordEncoder().encode(senha);
    }

    /**
     * Retorna a lista de perfis assossiados ao usuário.
     *
     * @return A lista de perfis do usuáiro.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return  A senha do usuário.
     */
    @Override
    public String getPassword(){
        return this.senha;
    }

    /**
     * Retorna o nome de usuário (e-mail).
     *
     * @return  O nome de usuário (e-mail).
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    /**
     * Verifica se a conta do usuário não está expirada.
     *
     * @return true se a conta não está expirada, caso contrário false.
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Verifica se a conta do usuário não está bloqueada.
     *
     * @return true se a conta não está bloqueada, caso contrario false.
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Verifica se as credenciais do usuário não está expiradas.
     *
     * @return true se as credenciais não estão expiradas, caso contrário false.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Verifica se o usuário está habilitado.
     *
     * @return true se o usuário está habilitado, caso contrário false.
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
