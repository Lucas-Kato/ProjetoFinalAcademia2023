package br.com.kaikei.dto;

import br.com.kaikei.model.Importacao;
import br.com.kaikei.model.Transacao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DetalheDTO {

    private String nomeUsuario;
    private LocalDateTime dataImportacao;
    private LocalDate dataTransacao;
    private List<Transacao> listaTransacao;

    /**
     * Construtor vazio da classe DetalheDTO.
     */
    public DetalheDTO() {
    }

    /**
     * Construtor da classe DetalheDTO
     *
     * @param importacao       a importação associada ao detalhe.
     * @param listaTransacao   a lista de transações associada ao detalhe.
     */
    public DetalheDTO(Importacao importacao, List<Transacao> listaTransacao){
        this.nomeUsuario = importacao.getUsuario().getNome();
        this.dataImportacao = importacao.getDataImportacao();
        this.dataTransacao = importacao.getDataTransacao();
        this.listaTransacao = listaTransacao;
    }

}
