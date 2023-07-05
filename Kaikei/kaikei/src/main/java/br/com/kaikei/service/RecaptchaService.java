package br.com.kaikei.service;

import br.com.kaikei.recaptcha.RecaptchaResponse;
/**
 * Interface que define o contrato para um serviço de ReCAPTCHA.
 */
public interface RecaptchaService {
    /**
     * Verifica a resposta do usuário a um desafio ReCAPTCHA.
     *
     * @param response a resposta fornecida pelo usuário ao desafion ReCAPTCHA.
     * @return         o objeto RecaptchaResponse contengo informações sobre o status da verificação.
     */
    RecaptchaResponse verify(String response);
}
