package com.proyecto.spring.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Seguridad {
	@Bean
	InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("admin")
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(admin);
	}

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

	    http
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/webjars/**")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/css/**")).permitAll()
	            .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
	            .anyRequest().authenticated()
	        )
	        .formLogin(login -> 
	        	login.loginPage("/")
	        	.loginProcessingUrl("/login")
	        	.defaultSuccessUrl("/index", true)
	        	.permitAll());

	    http.csrf(csrf -> csrf.disable());
	    http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

	    return http.build();
	}
}
