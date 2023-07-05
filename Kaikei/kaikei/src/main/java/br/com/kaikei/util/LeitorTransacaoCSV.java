package br.com.kaikei.util;

import br.com.kaikei.model.Transacao;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Classe utilitária para ler transações de um arquivo CSV.
 */
public class LeitorTransacaoCSV {
    /**
     * Lê as transações de um arquivo CSV e retorna uma lista de objetos Trasacao.
     *
     * @param arquivo   O InputStreamReader do arquivo CSV a ser lido.
     * @return          Uma lista de objetos Transacao ligos do arquivo CSV.
     */
    public List<Transacao> lerTransacao(InputStreamReader arquivo) {
        try {
            CSVReader reader = new CSVReaderBuilder(arquivo).build();
            List<String[]> linhas = reader.readAll();
            reader.close();
            List<Transacao> transacoes = new ArrayList<>();
            for (String[] linha : linhas) {
                List<String> lista = new ArrayList<>(Arrays.asList(linha));
                lista.removeIf(String::isBlank);
                try {
                    if (lista.size() == 8) {
                        transacoes.add(new Transacao(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), new BigDecimal(lista.get(6)),
                                LocalDateTime.parse(lista.get(7))));
                    }
                } catch (NullPointerException | NumberFormatException | DateTimeException exception) {

                }
            }
            return transacoes;
        } catch (IOException | CsvException e) {
            return null;
        }
    }
}
