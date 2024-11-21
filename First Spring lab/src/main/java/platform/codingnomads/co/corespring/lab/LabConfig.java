package platform.codingnomads.co.corespring.lab;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:xml-config/movie.xml"})
public class LabConfig {

    @Bean
    public Book book() {return new Book("Lord of the Flies", "William Golding");}

}
