package br.com.kaikei.repository;

import br.com.kaikei.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Interface de repositório para a entidade Transacao.
 * Extende JpaRepository para obter operações CRUD básicas de persistência.
 */
@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    /**
     * Busca uma transação pela data.
     *
     * @param data A data da transação.
     * @return  Uma Optional contendo a transação encontrada ou vazio se não encontrada.
     */
    @Query(value = "select * from transacao t where cast(t.data as date ) = :data LIMIT 1",
    nativeQuery = true)
    Optional<Transacao> findByData(@Param("data")LocalDate data);

    /**
     * Lista as transações por data.
     *
     * @param data  A data de transações.
     * @return  Uma lista de transações encontradas.
     */
    @Query(value = "select * from transacao t where cast(t.data as date) = :data",
    nativeQuery = true)
    List<Transacao> listarPorData(@Param("data") LocalDate data);

    /**
     * Realiza uma análise de transações com base no ano, mês e valor mínimo da transação.
     *
     * @param ano O ano da análise.
     * @param mes O mês da análise.
     * @return Uma lista de transações que atendem aos critérios da análise.
     */
    @Query("select t from Transacao t where year(t.data) = :ano and month(t.data) = :mes and t.valorTransacao >= 100000")
    List<Transacao> analiseTransacao(@Param("ano") Integer ano, @Param("mes") Integer mes);

    /**
     * Realiza uma análise de transações com base no ano e mês.
     *
     * @param ano   O ano da análise.
     * @param mes   O mês da análise.
     * @return      Uma lista de transaões que atendem aos critérios da análise.
     */
    @Query("select t from Transacao t where year(t.data) = :ano and month(t.data) = :mes")
    List<Transacao> analiseConta(Integer ano, Integer mes);
}
