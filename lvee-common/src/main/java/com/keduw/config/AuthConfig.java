/*package com.keduw.config;

import com.keduw.app.AuthDef;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(prefix = "lvee", name = "auth", havingValue = "true")
public class AuthConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser(AuthDef.ACCT)
                .password(new BCryptPasswordEncoder().encode(AuthDef.PASSWORD)).roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().anyRequest().fullyAuthenticated();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}*/
