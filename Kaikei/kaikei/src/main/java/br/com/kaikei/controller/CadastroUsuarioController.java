package br.com.kaikei.controller;

import br.com.kaikei.service.RecaptchaRegistroService;
import br.com.kaikei.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controladora responsável pelo cadastro de usuários.
 */
@Controller
@RequestMapping("/cadastrar")
public class CadastroUsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    private final RecaptchaRegistroService recaptchaRegistroService;
    private static final Logger log = LoggerFactory.getLogger(CadastroUsuarioController.class);

    /**
     * Contrutor da classe CadastroUsuarioController
     * @param recaptchaRegistroService o serviço RecaptchaRegistroService utilizado para verifiar o Recaptcha.
     */

    public CadastroUsuarioController(RecaptchaRegistroService recaptchaRegistroService) {
        this.recaptchaRegistroService = recaptchaRegistroService;
    }

    /**
     * Retorna a visualização da página de cadastro.
     *
     * @return o nome da página de cadastro.
     */

    @GetMapping
    public String cadastro() {
        return "cadastro";
    }

    /**
     * Realiza o cadastro de um novo usuário.
     *
     * @param nome o nome do usuário
     * @param email o e-mail do usuário
     * @param response a resposta do Recaptcha
     * @return um objeto ModelAndView contendo a visualização e as mensagens do cadastro.
     */

    @PostMapping
    public ModelAndView cadastro(@RequestParam String nome, @RequestParam String email, @RequestParam(name = "g-recaptcha-response") String response) {
        ModelAndView res;
        String result = usuarioService.cadastrarUsuario(nome, email);
        log.info("g-recaptcha-response: {}", response);

        //verificação a resposta di recaptcha
        recaptchaRegistroService.verify(response);
        if (result.substring(0, result.indexOf(":")).equals("erro")) {
            ModelAndView modelAndView = new ModelAndView("cadastro");
            res = modelAndView.addObject("msgError", result.substring(result.indexOf(":") + 1));
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            res = modelAndView.addObject("msgCadastro", "Sua senha para se logar foi enviada no email");
        }

        return res;
    }

}
