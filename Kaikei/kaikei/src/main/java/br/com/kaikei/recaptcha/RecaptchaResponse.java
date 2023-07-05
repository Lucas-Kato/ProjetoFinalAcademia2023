package br.com.kaikei.recaptcha;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Representa a resposta do ReCAPTCHA do Google.
 */
public class RecaptchaResponse {
    /**
     * Indica se a validação do ReCAPTCHA foi bem-sucedida.
     */
    private boolean success;
    /**
     * Pontuação atribuída à interação com o ReCAPTCHA.
     */
    private float score;
    /**
     * Ação assosiada ao ReCAPTCHA.
     */
    private String action;
    /**
     * Timestamp do desafion do ReCAPTCHA.
     */
    @JsonProperty("challenge_ts")
    private String challengeTs;
    /**
     * Nome do host do ReCAPTCHA.
     */
    private String hostname;
    /**
     * Lista de códigos de erro retornados pelo ReCAPTCHA.
     */
    @JsonProperty("error-codes")
    List<String> errorCodes;

    /**
     * Retorna se a validação do ReCAPTCHA foi bem-sucedida.
     *
     * @return true se a validação foi bem-sucedida.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Define se a validação do ReCAPTCHA foi bem-sucedida.
     *
     * @param success true se a validação foi bem-sucedida, caso contrário false.
     */

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Retorna a pontuação atribuída à interação com o ReCAPTCHA.
     *
     * @return A pontuaçao do ReCAPTCHA.
     */
    public float getScore() {
        return score;
    }

    /**
     * Define a pontuação atribuída à interação com o ReCAPTCHA.
     *
     * @param score A pontuação do ReCAPTCHA.
     */
    public void setScore(float score) {
        this.score = score;
    }

    public String getAction() {
        return action;
    }

    /**
     * Retorna a ação associada ao ReCAPTCHA.
     *
     * @param action A ação associada ao ReCAPTCHA.
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * Retorna o timestamp do desafio do ReCAPTCHA.
     *
     * @return O timestamp do desafio do ReCAPTCHA.
     */
    public String getChallengeTs() {
        return challengeTs;
    }

    /**
     * Define o timestamp do desafion do ReCAPTCHA.
     *
     * @param challengeTs O timestamp do desafio do ReCAPTCHA.
     */
    public void setChallengeTs(String challengeTs) {
        this.challengeTs = challengeTs;
    }

    /**
     * Retorna o nome do host do ReCAPTCHA.
     *
     * @return O nome do host do ReCAPTCHA.
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Define o nome do host do ReCAPTCHA.
     *
     * @param hostname O nome do host do ReCAPTCHA.
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * Retorna a lista de códigos de erro retornados pelo ReCAPTCHA.
     *
     * @return A lista de códigos de erro.
     */
    public List<String> getErrorCodes() {
        return errorCodes;
    }

    /**
     * Define a lista de códigos de erro retornados pelo ReCAPTCHA.
     *
     * @param errorCodes A lista de códigos de erro.
     */
    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    /**
     * Retorna uma representação em forma de string da resposta do ReCAPTCHA.
     *
     * @return Uma string representando a resposta do ReCAPTCHA.
     */
    @Override
    public String toString() {
        return "RecaptchaResponse{" +
                "success=" + success +
                ", score=" + score +
                ", action='" + action + '\'' +
                ", challengeTs='" + challengeTs + '\'' +
                ", hostname='" + hostname + '\'' +
                ", errorCodes=" + errorCodes +
                '}';
    }
}
