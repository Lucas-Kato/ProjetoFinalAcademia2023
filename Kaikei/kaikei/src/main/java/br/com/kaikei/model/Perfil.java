package br.com.kaikei.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * Representa um perfil de usuário no sistema.
 */
@Getter
@Setter
@Entity
public class Perfil implements GrantedAuthority {
    /**
     * Identificador único do perfil.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Nome do perfil.
     */
    private String perfil;

    /**
     * Retorna a autoridade do perfil.
     *
     * @return A autoridade do perfil.
     */

    @Override
    public String getAuthority(){
        return perfil;
    }

}
