package op2.ryhmatyo.pelisivusto;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
//import org.springframework.boot.web.servlet.dispatcherType;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(antMatcher("/css/**")).permitAll()
                .anyRequest().authenticated())
                //.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
            .headers(headers -> headers.frameOptions(frameoptions -> frameoptions.disable()))
            .formLogin() // Käytetään automaattista kirjautumissivua
                .defaultSuccessUrl("/", true) // Kirjautumisen jälkeen ohjataan etusivulle
                .permitAll()
            .and()
            .logout()
                .permitAll();
        return http.build();
    }


    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}