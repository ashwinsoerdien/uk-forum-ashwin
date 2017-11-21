package com.ashwin.ukforum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("writer").password("writer123")
				.roles("USER", "ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/{id}", "/new-article", "/article/{id}/new-comment", "/delete-article/{id}", "/edit-article/{id}").access("hasRole('USER')")
		.and()
			.formLogin().loginPage("/login")
			.defaultSuccessUrl("/index")
			.failureUrl("/login?error")
			.usernameParameter("username").passwordParameter("password")				
		.and()
			.logout().logoutSuccessUrl("/login?logout");
	
	}
}