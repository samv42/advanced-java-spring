package platform.codingnomads.co.springweb.resttemplate.POST.postForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserData;

import java.util.Objects;

@SpringBootApplication
public class postForEntityMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(postForEntityMain.class, args);
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
                    .name("learn how to use postForEntity()")
                    .description("get comfortable using the RestTemplate postForEntity() method")
                    .userId(5)
                    .completed(false)
                    .build();

            ResponseEntity<ResponseObject> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
            } else {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()).getError());
            }*/
            UserData newUser1 = UserData.builder()
                    .id(7)
                    .email("new email 1")
                    .first_name("Will")
                    .last_name("Mulberry")
                    .build();
            UserData newUser2 = UserData.builder()
                    .id(8)
                    .email("new email 2")
                    .first_name("Gary")
                    .last_name("Smith")
                    .build();
            ResponseEntity<User> responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser1, User.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
            } else {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()).getError());
            }
            responseEntity = restTemplate
                    .postForEntity("http://demo.codingnomads.co:8080/tasks_api/users", newUser2, User.class);

            if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()));
            } else {
                System.out.println(Objects.requireNonNull(responseEntity.getBody()).getError());
            }
        };
    }
}
