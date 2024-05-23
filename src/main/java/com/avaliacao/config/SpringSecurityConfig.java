package com.avaliacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		http
		.csrf().disable()
		.authorizeHttpRequests((requests)-> requests

				.requestMatchers(
						"/v3/api-docs/**",
	                    "/swagger-ui/**")
				.permitAll()
				.requestMatchers(
						HttpMethod.POST,"/aluno/", "/turma/")
				.authenticated()

				.requestMatchers(
						HttpMethod.GET,"/aluno/", "/turma/")
				.permitAll()
				.requestMatchers(
						HttpMethod.DELETE,"/aluno/", "/turma/{id}")
				.authenticated()

				.requestMatchers(
						HttpMethod.PUT,"/turma/**")
				.authenticated()			
				.anyRequest()
				.authenticated()	

				)
		.httpBasic();
		return http.build();

	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService(){
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("adriano")
				.password("123456")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);

	}

}