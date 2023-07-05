package br.com.kaikei.controller;

import br.com.kaikei.dto.DetalheDTO;
import br.com.kaikei.model.Importacao;
import br.com.kaikei.service.ImportacaoService;
import br.com.kaikei.service.TransacaoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controladora responsável pela importação de arquivos e exibição de detalhes.
 */
@AllArgsConstructor
@Controller
@RequestMapping("/importar")
public class ImportacaoController {

    private TransacaoService transacaoService;
    private ImportacaoService importacaoService;

    /**
     * Retorna a visualização da página de importação.
     *
     * @return um objeto ModelAndView contendo a visualização da página e a lista de importações.
     */

    @GetMapping
    public ModelAndView viewImport(){
        ModelAndView modelAndView = new ModelAndView("importacao");
        return modelAndView.addObject("listImportacao", importacaoService.listarImportacao());
    }

    /**
     * Importa um arquivo.
     *
     * @param arquivo o arquivo a ser importado
     * @return um objeto ModelAndView para redirecionar para a página de importação
     */

    @PostMapping("salvar")
    public ModelAndView importarArquivo(@RequestParam("arquivo")MultipartFile arquivo) {
        ModelAndView modelAndView = new ModelAndView("redirect:/importar");
        String result = transacaoService.salvarTransacao(arquivo);
        if (result.substring(0, result.indexOf(":")).equals("erro")){
            return modelAndView.addObject("errMessage", result.substring(result.indexOf(":") + 1));
        }
        return modelAndView.addObject("scssMessage", result.substring(result.indexOf(":") + 1));
    }
    /**
     * Exibe os detalhes de uma importação.
     *
     * @param id o ID da importação
     * @return um objeto ModelAndView contendo a visualização da página de detalhes e os detalhes da importação
     */
    @GetMapping("detalhar")
    public ModelAndView detalharView(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("detalhar");
        Importacao importacao = importacaoService.buscarPorId(id);
        DetalheDTO detalhar = new DetalheDTO(importacao, transacaoService.listarTransacoesData(importacao.getDataTransacao()));
        return modelAndView.addObject("detalhar", detalhar);
    }

}
