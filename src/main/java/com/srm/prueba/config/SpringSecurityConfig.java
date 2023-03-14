package com.srm.prueba.config;

import com.srm.prueba.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig{
	
	
//	 	@Bean
//	    public UserDetailsService userDetailsService() {
//	        return new ShopmeUserDetailsService();
//	    }
	 
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			CustomUserDetailsService usuario = new CustomUserDetailsService();

	    	http
					.cors().and()
					.csrf().disable()
					.authorizeHttpRequests()
						.requestMatchers("resources/static/js/**").permitAll()
	    				.requestMatchers("/login", "/new", "/user/**").permitAll()
	                	.requestMatchers("/admin").hasRole("ROLE_ADMINISTRADOR")
						.anyRequest().authenticated()
					.and()
						.formLogin()
	    				.loginPage("/login")
					;

	       http.headers().frameOptions().sameOrigin();
	 
	        return http.build();
	    }



    }

