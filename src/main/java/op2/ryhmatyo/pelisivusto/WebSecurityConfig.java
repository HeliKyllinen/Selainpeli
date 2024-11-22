package op2.ryhmatyo.pelisivusto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/css/**", "/login").permitAll() // Salli kirjautumissivu ja CSS
                .anyRequest().authenticated())
            .formLogin(form -> form
                .loginPage("/login") // Osoitetaan oma kirjautumissivu
                .defaultSuccessUrl("/home", true) // Ohjataan onnistuneen kirjautumisen jälkeen
                .permitAll())
            .logout()
                .permitAll();

        return http.build();
    }
}