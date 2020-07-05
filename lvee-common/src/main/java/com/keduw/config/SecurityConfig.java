package com.keduw.config;

import com.keduw.app.AuthDef;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${lvee.security:true}")
    private boolean isOpen;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        if(!isOpen){
            return;
        }
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser(AuthDef.ACCT)
                .password(new BCryptPasswordEncoder().encode(AuthDef.PASSWORD)).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if(!isOpen){
            return;
        }
        http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
