package com.codebytes.partnerportal.partner.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class PartnerBrandSecurityConfiguration {
    @Configuration
    public static class SpringSecurityClientAdapterConfiguration extends WebSecurityConfigurerAdapter {
        @Autowired
        private DataSource dataSource;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery("SELECT username, password, enabled FROM partner_brand WHERE username = ?")
                    .authoritiesByUsernameQuery("SELECT username, role FROM partner_brand WHERE username=? AND role='SELLER'");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {

            String[] permitAll = {"/template/**", "/h2-console/**"};
            String[] ignore = {"/h2-console/**"};
            String[] anonymous = {"/seller-sign-up"};
            String[] seller = {"/dashboard/**"};

            http.antMatcher("/**")
                    .authorizeRequests()
                    .antMatchers(permitAll).permitAll()
                    .and()
                    .authorizeRequests()
                    .antMatchers(anonymous).anonymous()
                    .and()
                    .authorizeRequests()
                    .antMatchers(seller).hasAuthority("SELLER")
                    .and()
                    .formLogin()
                    .loginPage("/")
                    .defaultSuccessUrl("/")
                    .permitAll()
                    .and()
                    .logout()
                    .logoutSuccessUrl("/?logout")
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
