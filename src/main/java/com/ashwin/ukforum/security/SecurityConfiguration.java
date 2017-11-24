package com.ashwin.ukforum.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ashwin").password("ashwin").roles("USER");
        auth.inMemoryAuthentication().withUser("writer").password("writer123").roles("USER", "ADMIN");
        auth.inMemoryAuthentication().withUser("phoebe").password("phoebe").roles("USER");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {       
      http.authorizeRequests()
        .antMatchers("/", "/articles", "/search").permitAll()
        .antMatchers("/newarticle", "/newcomment/article/**", "/myarticles/**", "/editarticle", "/deletearticle").access("hasRole('USER')")
        .antMatchers("/admin/**", "/rejectarticle", "/approvearticle").access("hasRole('ADMIN')")
        .and().formLogin().loginPage("/login").defaultSuccessUrl("/myarticles", true)
        .usernameParameter("username").passwordParameter("password")
        .and().csrf()
        .and().exceptionHandling().accessDeniedPage("/accessdenied");
    }
}
