package br.com.kaikei.controller;

import br.com.kaikei.service.AnaliseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador de análise de dados.
 */
@AllArgsConstructor
@Controller
@RequestMapping(value = "analise")
public class AnaliseController {

    private AnaliseService analiseService;

    /**
     * Visualização da página de analise.
     * @return o nome da página de análise.
     */
    @GetMapping
    public String viewAnalysis(){
        return "analise";
    }

    /**
     * Realiza a análise de transações, contas e agência para determinado mês e ano.
     * @param data a data no formato "yyyy-MM" (ano-mês)
     * @return um objeto ModelAndView contendo a visualizaçao e os resultado da análise.
     */

    @PostMapping
    public ModelAndView analisarMes(@RequestParam String data) {
        ModelAndView modelAndView = new ModelAndView("analise");
        if (data != null && !data.isEmpty()) {
            Integer ano = Integer.parseInt(data.substring(0, data.indexOf("-")));
            Integer mes = Integer.parseInt(data.substring(data.indexOf("-") + 1));

            //Realiza a análise das transações, contas e agências para determinado ano e mês.
            modelAndView.addObject("transacoesSuspeitas", analiseService.analisarTransacao(ano, mes));
            modelAndView.addObject("contaSuspeitas", analiseService.analisarConta(ano, mes));
            modelAndView.addObject("agenciaSuspeitas", analiseService.analisarAgencia(ano, mes));
        }
        return modelAndView;
    }


}
