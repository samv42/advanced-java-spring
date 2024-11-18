package platform.codingnomads.co.corespring.examples.beanscopes.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.swing.*;

@Configuration
public class SingletonDemoConfig {
    @Bean
    @Scope(value = "singleton")
    public SpringBean springBean() {
        return new SpringBean();
    }
    @Bean
    public OtherBean otherBean() {return new OtherBean(); }
}