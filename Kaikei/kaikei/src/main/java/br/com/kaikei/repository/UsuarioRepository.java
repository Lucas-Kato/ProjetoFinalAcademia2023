package br.com.kaikei.repository;

import br.com.kaikei.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Interface de repositório para a entidade Usuario.
 * Extende JpaRepositoru para obter operações CRUD básicas de persistência.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /**
     * Busca um usuário pelo e-mail.
     *
     * @param email O e-mail do usuário.
     * @return Um Optional contendo o usuário encontrado ou vazio se não encontrado.
     */
    Optional<Usuario> findByEmail(@Param("email") String email);

    /**
     * Busca todos os usuários ativos.
     *
     * @return Uma lista de usuários ativos.
     */
    @Query("select u from Usuario u where u.ativo = true ")
    List<Usuario> buscarTodos();

}
