package br.com.kaikei.recaptcha;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Representa as chaves de configuração do ReCAPTHA do Google.
 */
@Component
@ConfigurationProperties(prefix = "google.recaptcha.key")
public class RecaptchaKeys {
    /**
     * Chave do site do ReCAPTCHA.
     */
    private String site;
    /**
     * Chave secreta do ReCAPTCHA.
     */
    private String secret;
    /**
     * Limiar de pontução mínimo para validar o ReCAPTCHA.
     */
    private float threshold;

    /**
     * Retorna a chave do site do ReCAPTCHA.
     *
     * @return  A chave do site do ReCAPTCHA
     */
    public String getSite() {
        return site;
    }

    /**
     * Define a chave do site do ReCAPTCHA.
     *
     * @param site A chave do site do ReCAPTCHA.
     */
    public void setSite(String site) {
        this.site = site;
    }

    /**
     * Retorna a chave secreta do ReCAPTCHA.
     *
     * @return A chave secreta do ReCAPTCHA.
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Difine a chave secreta do ReCAPTCHA.
     *
     * @param secret A chave secreta do ReCAPTCHA.
     */
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * Retorna o limiar de pontuação mínimo para validar o ReCAPTCHA.
     *
     * @return O limiar de pontuação mínimo.
     */
    public float getThreshold() {
        return threshold;
    }

    /**
     * Define o limiar de pontuação mínimo para validar o ReCAPTCHA.
     *
     * @param threshold O limiar de pontuação mínimo.
     */
    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }
}
