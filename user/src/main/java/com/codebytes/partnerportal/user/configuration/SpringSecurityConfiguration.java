package com.codebytes.partnerportal.user.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration {
	
	@Configuration
	public static class SpringSecurityClientAdapterConfiguration extends WebSecurityConfigurerAdapter {
		@Autowired
		private DataSource dataSource;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication()
				.dataSource(dataSource)
					.usersByUsernameQuery("SELECT username, password, enabled FROM CUSTOMER WHERE username = ?")
					.authoritiesByUsernameQuery("SELECT username, role FROM CUSTOMER WHERE username=? AND role='BUYER'");
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			String[] permitAll = {"/template/**", "/h2-console/**", "/search", "/product"};
			String[] ignore = {"/h2-console/**"};
			String[] anonymous = {"/sign-up"};
			String[] buyer = {"/cart/**","/checkout/**"};
			
			
			http.antMatcher("/**")
				.authorizeRequests()
				.antMatchers(permitAll).permitAll()
					.and()
				.authorizeRequests()
				.antMatchers(anonymous).anonymous()
					.and()
				.authorizeRequests()
				.antMatchers(buyer).hasAuthority("BUYER")
					.and()
				.formLogin()
					.loginPage("/sign-in")
					.defaultSuccessUrl("/")
					.permitAll()
					.and()
				.logout()
					.logoutSuccessUrl("/sign-in?logout")
					.permitAll()
					.and()
				.csrf()
					.ignoringAntMatchers(ignore)
					.and()
				.headers()
					.frameOptions()
					.sameOrigin();

		}
	}
	
}
