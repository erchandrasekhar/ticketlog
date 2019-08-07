package com.ticketlog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ticketlog.services.UserDetailServiceImpl;


@Configuration
@EnableWebSecurity
public class ticketlogSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailServiceImpl userDetailService;
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests().antMatchers("/index", "/home", "/").access("hasRole('USER') or hasRole('ADMIN')")
			.and()
			.formLogin().defaultSuccessUrl("/home").loginPage("/login")
			.and().logout().permitAll();*/
		
		http.authorizeRequests()
			.antMatchers("/resources/**","/static/**").permitAll()
			.antMatchers("/index/", "/home/", "/**").hasAnyAuthority("USER", "ADMIN","DEVELOPER")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").defaultSuccessUrl("/home").permitAll().failureUrl("/login?error=true")
			.and()
			.exceptionHandling().accessDeniedPage("/login")
			.and()
			.logout().permitAll();

		http.csrf().disable();
			
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
		
		auth.inMemoryAuthentication()
				.withUser("admin").password("password").roles("ADMIN");*/
		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
}
