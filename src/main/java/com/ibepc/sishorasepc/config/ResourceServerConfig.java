package com.ibepc.sishorasepc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/* GUILHERME 20/04/21 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    /*.antMatchers("/areas/**").hasAnyRole("USER") EXEMPLO DE REGRAS*/
                    .antMatchers("/api/usuarios/**").permitAll()
                    .antMatchers("/atvdocs/**").authenticated()
                    .antMatchers("/projetos/**").authenticated()
                    .antMatchers("/setores/**").authenticated()
                    .antMatchers("/status/**").authenticated()
                    .antMatchers("/usuarios/**").authenticated()
                    .anyRequest().denyAll();
    }
}
