package br.com.kaikei.service;

import br.com.kaikei.model.Importacao;
import br.com.kaikei.model.Transacao;
import br.com.kaikei.repository.TransacaoRepository;
import br.com.kaikei.util.LeitorTransacaoCSV;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Serviço responsável por manipular as transações.
 */
@AllArgsConstructor
@Service
public class TransacaoService {
    private TransacaoRepository transacaoRepository;
    private ImportacaoService importacaoService;
    private UsuarioService usuarioService;

    /**
     * Salva as transações a partir de um arquivo CSV.
     *
     * @param arquivo O arquivo CSV contendo as transações a serem salvas.
     * @return  Uma mensagem indicando o resultado da operaçõa.
     *          - Em caso de sucesso, retorna "Transações salvas com sucesso".
     *          - Em caso de erro, retorna uma mensagem de erro específica.
     */
    public String salvarTransacao(MultipartFile arquivo) {
        try {
            List<Transacao> transacoes;
            if (Objects.requireNonNull(arquivo.getContentType()).contains("csv")){
                transacoes = new LeitorTransacaoCSV().lerTransacao(new InputStreamReader(arquivo.getInputStream()));
            } else {
                return "erro: Formato de arquivo inválido";
            }
            if (transacoes.size() == 0){
                return "erro: O arquivo está vazio";
            }
            String data = transacoes.get(0).getData().toString().substring(0, transacoes.get(0).getData().toString().indexOf("T"));
            if (existeBanco(data)) {
                return "erro: Já foi feita uma importação com essa data de transações";
            }
            transacoes = transacoes.stream()
                    .filter(x -> x.getData().toString().contains(data))
                    .collect(Collectors.toList());
            transacaoRepository.saveAll(transacoes);

            String email = SecurityContextHolder.getContext().getAuthentication().getName();
            importacaoService.salvar(new Importacao(LocalDateTime.now(), LocalDate.parse(data), usuarioService.buscarPorEmail(email)));
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            return "erro: Não foi possível ler o arquivo, verifique o arquivo e tente novamente";
        }
        return "scss: Transações salvas com sucesso";
    }

    /**
     * Verifica se já existe uma importação com a data específicada.
     *
     * @param data A data a ser verificada.
     * @return  true se já existe uma importação com a data, false caso contrario false.
     */
    private boolean existeBanco(String data){
        return transacaoRepository.findByData(LocalDate.parse(data)).isPresent();
    }

    /**
     * Lista as transações de uma determinada data.
     *
     * @param data A data das transações a serem listadas.
     * @return     Uma lista de transações correspondentes à data especificadas.
     */
    public List<Transacao> listarTransacoesData(LocalDate data){
        return transacaoRepository.listarPorData(data);
    }
}
