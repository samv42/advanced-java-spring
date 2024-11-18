package platform.codingnomads.co.springtest.usingtestresttemplate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .cors().disable()
                .csrf().disable()
                .authorizeRequests().anyRequest().permitAll();
    }
}
