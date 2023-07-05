package br.com.kaikei.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controladora responsável pela exibição da página de login.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
    /**
     * Retorna a visualização da página de login
     *
     * @return o nome da página de login
     */
    @GetMapping
    public String viewLogin(){
        return "/login";


    }
}
