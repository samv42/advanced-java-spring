package platform.codingnomads.co.springweb.resttemplate.POST.postForLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserData;

import java.net.URI;
import java.util.Objects;

@SpringBootApplication
public class postForLocationMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(postForLocationMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            //Example
            /*Task newTask = Task.builder()
                    .name("learn how to use postForLocation()")
                    .description("get comfortable using the RestTemplate postForLocation() method")
                    .userId(5)
                    .completed(false)
                    .build();

            //use postForLocation() to get the URL for the new resource
            URI returnedLocation = restTemplate
                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            System.out.println(Objects.requireNonNull(returnedLocation));

            ResponseEntity<?> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            System.out.println(responseEntity.getHeaders().get("Location"));
             */
            UserData newUser = UserData.builder()
                    .id(11)
                    .email("Tom's email")
                    .first_name("Tom")
                    .last_name("John")
                    .build();
            URI returnedLocation = restTemplate
                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/users", newUser, User.class);

            System.out.println(Objects.requireNonNull(returnedLocation));

            ResponseEntity<?> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser, User.class);

            System.out.println(responseEntity.getHeaders().get("Location"));

            UserData newUser2 = UserData.builder()
                    .id(9)
                    .email("newuser2@gmail.com")
                    .first_name("William")
                    .last_name("Scott")
                    .build();
            URI returnedLocation2 = restTemplate
                    .postForLocation("http://demo.codingnomads.co:8080/tasks_api/users", newUser, User.class);

            System.out.println(Objects.requireNonNull(returnedLocation));

            responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser, User.class);

            System.out.println(responseEntity.getHeaders().get("Location"));
        };
    }
}
