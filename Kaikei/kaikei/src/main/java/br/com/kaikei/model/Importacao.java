package br.com.kaikei.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Representa um importação no sistema.
 */
@Getter
@Setter
@Entity
public class Importacao {
    /**
     * Indetificador único da importção.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Data e hora da importação.
     */
    private LocalDateTime dataImportacao;
    /**
     * Data da transação.
     */
    private LocalDate dataTransacao;
    /**
     * Usuário associado à importação.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    /**
     * Contrutor vazio da classe Importação.
     */
    public Importacao() {
    }

    /**
     * Contrói uma nova instância da classe Importação com os detalhes específicados.
     *
     * @param dataImportacao Data e hora da importação.
     * @param dataTransacao  Data da transação.
     * @param usuario        Usuário associado à importação.
     */
    public Importacao(LocalDateTime dataImportacao, LocalDate dataTransacao, Usuario usuario) {
        this.dataImportacao = dataImportacao;
        this.dataTransacao = dataTransacao;
        this.usuario = usuario;
    }
}
