package br.com.kaikei.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representa uma transação no sistema.
 */
@Getter
@Setter
@Entity
public class Transacao {
    /**
     * Identificador único da transação.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Banco de origem da transação.
     */
    private String bancoOrigem;
    /**
     * Agência de origem da transação.
     */
    private String agenciaOrigem;
    /**
     * Conta de origem da transação.
     */
    private String contaOrigem;
    /**
     * Banco de destino da transação.
     */
    private String bancoDestino;
    /**
     * Agência de destino da transação.
     */
    private String agenciaDestino;
    /**
     * Conta de destino da transação.
     */
    private String contaDestino;
    /**
     * Valor da transação.
     */
    private BigDecimal valorTransacao;
    /**
     * Data e hora da transação.
     */
    private LocalDateTime data;

    /**
     * Contrutor vazio da classe Transacao.
     */
    public Transacao() {
    }

    /**
     * Contrói uma nova instância da classse Transação com os detalhes especificados.
     * @param bancoOrigem       Banco de origem da transação.
     * @param agenciaOrigem     Agência de origem da transação.
     * @param contaOrigem       Conta de origem da transação.
     * @param bancoDestino      Banco de destino da transação.
     * @param agenciaDestino    Agência de destino da transação.
     * @param contaDestino      Conta de destino da transação.
     * @param valorTransacao    Valor da transação.
     * @param data              Data e hora da transação.
     */
    public Transacao(String bancoOrigem, String agenciaOrigem, String contaOrigem, String bancoDestino, String agenciaDestino, String contaDestino, BigDecimal valorTransacao, LocalDateTime data) {
        this.bancoOrigem = bancoOrigem;
        this.agenciaOrigem = agenciaOrigem;
        this.contaOrigem = contaOrigem;
        this.bancoDestino = bancoDestino;
        this.agenciaDestino = agenciaDestino;
        this.contaDestino = contaDestino;
        this.valorTransacao = valorTransacao;
        this.data = data;
    }
}
