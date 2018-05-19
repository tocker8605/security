package com.tocker.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private ApplicationContext applicationContext;

    @Autowired
    public SecurityConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**")
                .permitAll()
            .and()
                .logout()
                .logoutUrl("/sign-out")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
            .and()
                .formLogin()
                .loginPage("/sign-in")
                .loginProcessingUrl("/sign-in/auth")
                .failureUrl("/sign-in?error=exception")
                .defaultSuccessUrl("/");
//            .and()
//                .addFilterBefore((Filter) applicationContext.getBean("sso.filter"), BasicAuthenticationFilter.class);
    }

}
