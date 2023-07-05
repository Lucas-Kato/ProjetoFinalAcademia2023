package br.com.kaikei.service;

import br.com.kaikei.model.Importacao;
import br.com.kaikei.repository.ImportacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ImportacaoService {

    private ImportacaoRepository importacaoRepository;

    /**
     * Retorna a lista de todas as importações.
     *
     * @return a lista de importações.
     */
    public List<Importacao> listarImportacao() {
        return importacaoRepository.findAll();
    }

    /**
     * Busca uma importação pelo seu ID.
     *
     * @param id o ID da importação a ser buscada.
     * @return   a importação encontrada, ou null se não for encontrada.
     */
    public Importacao buscarPorId(Long id) {
        return importacaoRepository.findById(id).get();
    }

    /**
     * Salva uma importação.
     *
     * @param importacao a importação a ser salva.
     */
    public void salvar(Importacao importacao){
        importacaoRepository.save(importacao);
    }
}
