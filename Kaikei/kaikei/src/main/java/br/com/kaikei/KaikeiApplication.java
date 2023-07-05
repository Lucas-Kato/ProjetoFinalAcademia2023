package br.com.kaikei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class KaikeiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KaikeiApplication.class, args);
	}

	/**
	 * Cria uma instância de RestTemplate para fazer chamadas HTTP.
	 *
	 * @return uma instância de RestTemplate.
	 */
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}





