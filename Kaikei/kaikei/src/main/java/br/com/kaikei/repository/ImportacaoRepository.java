package br.com.kaikei.repository;

import br.com.kaikei.model.Importacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de repositório para a entidade Importacao.
 * Extende JpaRepository para obter operações CRUD básicos de persistência.
 */
@Repository
public interface ImportacaoRepository extends JpaRepository<Importacao, Long> {
}
