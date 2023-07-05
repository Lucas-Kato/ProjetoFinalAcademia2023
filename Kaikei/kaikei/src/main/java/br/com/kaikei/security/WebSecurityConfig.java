package br.com.kaikei.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuração de segurança da web usando o Spring Security.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    /**
     * Configuração do filtro de segurança.
     *
     * @param http  O objeto HttpSecurity usado para configurar a segurança.
     * @return      O filtro de segurança configurado.
     * @throws Exception    Se ocorrer um erro durante a configuração.
     */
    @Bean
    protected SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                    .requestMatchers("/cadastrar","/login").permitAll()
                        .anyRequest()
                            .authenticated()
                .and()
                    .formLogin(form -> form
                        .loginPage("/login")
                            .defaultSuccessUrl("/importar", true)
                                .permitAll()
                )
                .logout(logout -> {
                    logout.logoutUrl("/logout");
                })
                .csrf(AbstractHttpConfigurer::disable)
                    .headers()
                        .xssProtection()
                            .disable();
        return http.build();
    }

    /**
     * Cria um codificador de senhas.
     *
     * @return  O codificador de senhas.
     */
    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
