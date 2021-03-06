package com.in28minutes.spring.rest.restfulapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class UserSecurity extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	          .withUser("restapi").password(passwordEncoder().encode("restapipass"))
	          .authorities("ROLE_ADMIN");
	    }
	 
	 @Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		 httpSecurity.csrf()
		 	.disable()
		 	.authorizeRequests()
		 	.antMatchers("/restapi/**").permitAll()
		 	.anyRequest().authenticated()
		 	.and().httpBasic();
		 
		 	 httpSecurity.headers().frameOptions().disable();
	}
	 
	 @Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
}
