package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
		return http.csrf(AbstractHttpConfigurer::disable)
					.authorizeHttpRequests(request->request.anyRequest().authenticated())
//					.formLogin(Customizer.withDefaults())
					.httpBasic(Customizer.withDefaults())
					.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
					.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User
				.withDefaultPasswordEncoder()
				.username("chanchal")
				.password("vani")
				.roles("USER").build();
				
		return new  InMemoryUserDetailsManager(user1);
	}

}
