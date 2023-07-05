package br.com.kaikei.service;

import br.com.kaikei.dto.ContaDTO;
import br.com.kaikei.dto.AgenciaDTO;
import br.com.kaikei.model.Transacao;
import br.com.kaikei.repository.TransacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class AnaliseService {

    private TransacaoRepository transacaoRepository;

    /**
     * Realiza a análise das transações com base no ano e mês fornecidos.
     * @param ano   ano das transações a serem analisadas.
     * @param mes   mês das transações a serem analisadas.
     * @return  a lista de transações analisadas.
     */

    public List<Transacao> analisarTransacao(Integer ano, Integer mes) {
        return transacaoRepository.analiseTransacao(ano, mes);
    }

    /**
     * Realiza a análise das contas com base no ano e mês fornecidos.
     *
     * @param ano   o ano das contas a serem analisadas.
     * @param mes   o mês das contas a serem analisadas.
     * @return      a lista de contas analisadas.
     */
    public List<ContaDTO> analisarConta(Integer ano, Integer mes) {

        List<Transacao> listaTransacao = transacaoRepository.analiseConta(ano, mes);

        List<ContaDTO> contas = new ArrayList<>();

        for (Transacao transacao : listaTransacao) {

            ContaDTO contaSaida = new ContaDTO(transacao.getBancoOrigem(),
                    transacao.getAgenciaOrigem(),
                    transacao.getContaOrigem(),
                    transacao.getValorTransacao(),
                    "SAIDA");

            ContaDTO contaEntra = new ContaDTO(transacao.getBancoDestino(),
                    transacao.getAgenciaDestino(),
                    transacao.getContaDestino(),
                    transacao.getValorTransacao(),
                    "ENTRADA");

            if (! contas.contains(contaSaida)) {
                contas.add(contaSaida);
            } else {
                contas.get(contas.indexOf(contaSaida)).somarValor(contaSaida.getValorMovimento());
            }
            if (! contas.contains(contaEntra)) {
                contas.add(contaEntra);
            } else {
                contas.get(contas.indexOf(contaEntra)).somarValor(contaEntra.getValorMovimento());
            }
        }
        contas.removeIf(conta -> conta.getValorMovimento().compareTo(new BigDecimal(1000000)) <= 0);
        return contas;
    }

    /**
     * Realiza a análise das agências com base no ano e mês fornecidos.
     *
     * @param ano   o ano das agências a serem analisadas.
     * @param mes   o mês das agências a serem analisadas.
     * @return      a lista de agências analisadas.
     */
    public List<AgenciaDTO> analisarAgencia(Integer ano, Integer mes) {

        List<Transacao> transactionList = transacaoRepository.analiseConta(ano, mes);

        List<AgenciaDTO> agencias = new ArrayList<>();

        for (Transacao transacao : transactionList) {
            AgenciaDTO agenciaSaida = new AgenciaDTO(transacao.getBancoOrigem(),
                    transacao.getAgenciaOrigem(),
                    transacao.getValorTransacao(),
                    "SAIDA");

            AgenciaDTO agenciaEntrada = new AgenciaDTO(transacao.getBancoDestino(),
                    transacao.getAgenciaDestino(),
                    transacao.getValorTransacao(),
                    "ENTRADA");
            if (! agencias.contains(agenciaSaida)) {
                agencias.add(agenciaSaida);
            } else {
                agencias.get(agencias.indexOf(agenciaSaida)).somarValor(agenciaSaida.getValorMovimento());
            }
            if (! agencias.contains(agenciaEntrada)) {
                agencias.add(agenciaEntrada);
            } else {
                agencias.get(agencias.indexOf(agenciaEntrada)).somarValor(agenciaEntrada.getValorMovimento());
            }
        }
        agencias.removeIf(conta -> conta.getValorMovimento().compareTo(new BigDecimal(1000000000)) <= 0);
        return agencias;
    }
}
