package platform.codingnomads.co.springweb.resttemplate.GET.getForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.Excuse;
import platform.codingnomads.co.springweb.resttemplate.GET.models.ExcuseTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.KanyeTemplate;

import java.util.Arrays;

@SpringBootApplication
public class GetForObjectDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForObjectDemo.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            //KanyeTemplate kanyeQuote;
            //kanyeQuote = restTemplate.getForObject("https://api.kanye.rest/", KanyeTemplate.class);
            //System.out.println(kanyeQuote.toString());
           ExcuseTemplate[] excuseTemplate;
            ExcuseTemplate[] excuseTemplate2;
            ExcuseTemplate oneExcuse;
           excuseTemplate = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse", ExcuseTemplate[].class);
            System.out.println(Arrays.toString(excuseTemplate));
            excuseTemplate2 = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/4", ExcuseTemplate[].class);
            System.out.println(Arrays.toString(excuseTemplate2));
            oneExcuse = restTemplate.getForObject("https://excuser-three.vercel.app/v1/excuse/id/104", ExcuseTemplate.class);
            System.out.println(oneExcuse.toString());
            // submit more requests here
        };
    }
}
