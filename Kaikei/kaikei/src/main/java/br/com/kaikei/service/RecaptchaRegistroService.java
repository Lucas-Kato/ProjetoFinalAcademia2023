package br.com.kaikei.service;

import br.com.kaikei.recaptcha.RecaptchaKeys;
import br.com.kaikei.recaptcha.RecaptchaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Serviço responsável pro verificar a resposta do ReCAPTCHA durante o registro.
 */
@Service
public class RecaptchaRegistroService implements RecaptchaService{

    private final RecaptchaKeys recaptchaKeys;
    private final RestTemplate restTemplate;
    private static final Logger log = LoggerFactory.getLogger(RecaptchaRegistroService.class);

    /**
     * Construtor que recebe as chaves do ReCAPTCHA e o RestTemplate.
     *
     * @param recaptchaKeys as chaves do ReCAPTCHA.
     * @param restTemplate  o RestTamplate para fazer chamadas HTTP.
     */
    @Autowired
    public RecaptchaRegistroService(RecaptchaKeys recaptchaKeys, RestTemplate restTemplate) {
        this.recaptchaKeys = recaptchaKeys;
        this.restTemplate = restTemplate;
    }

    /**
     * Verifica se a resposta do ReCAPTCHA é válida.
     *
     * @param response  a resposta do ReCAPTCHA
     * @return o objeto RecaptchaResponse contendo o resultado da verificação.
     */
    @Override
    public RecaptchaResponse verify(String response) {
        //API request
        URI verifyURI = URI.create(String.format("https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s",
                recaptchaKeys.getSecret(), response));
        //faz HTTP charmar usando RestTemplate
        RecaptchaResponse recaptchaResponse = restTemplate.getForObject(verifyURI, RecaptchaResponse.class);

        //log do retorno do objeto RecaptchaResponse
        log.info("response depois da verificação : {}", recaptchaResponse);

        if (recaptchaResponse != null) {
            if (recaptchaResponse.isSuccess() && (recaptchaResponse.getScore() < recaptchaKeys.getThreshold()
            || !recaptchaResponse.getAction().equals("cadastro"))){
                recaptchaResponse.setSuccess(false);
            }
        }
        return recaptchaResponse;
    }
}
