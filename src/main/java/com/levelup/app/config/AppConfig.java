package com.levelup.app.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.levelup.app.security.filters.JwtAuthenticationFilter;
import com.levelup.app.security.filters.JwtValidationFilter;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.POST, "/api/v1/auth/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/locations/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/productos/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/v1/categories").permitAll()
                .requestMatchers(
                        "/swagger-ui.html",
                        "/swagger-ui/**",
                        "/v3/api-docs/**")
                .permitAll()
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/api/v1/auth/isadmin").hasAnyRole("ADMIN","VENDEDOR")
                .requestMatchers(HttpMethod.GET, "/api/v1/users/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/api/v1/users/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/v1/users/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/users/**").hasRole("ADMIN")
                
                .requestMatchers(HttpMethod.POST, "/api/v1/productos").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/v1/productos/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/v1/productos/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/roles").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/api/v1/sales/**").hasAnyRole("ADMIN","VENDEDOR")
                .requestMatchers(HttpMethod.POST, "/api/v1/sales/**").hasAnyRole("USER", "VENDEDOR")

                .anyRequest().authenticated())
                .addFilterBefore(new JwtAuthenticationFilter(authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtValidationFilter(authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .csrf((csrf) -> csrf.disable())
                .cors((cors) -> cors.configurationSource(configurationSource()))
                .sessionManagement((managment) -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    CorsConfigurationSource configurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOriginPatterns(java.util.Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
