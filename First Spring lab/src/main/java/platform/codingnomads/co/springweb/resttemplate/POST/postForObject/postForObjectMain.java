package platform.codingnomads.co.springweb.resttemplate.POST.postForObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.POST.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.POST.models.Task;
import platform.codingnomads.co.springweb.resttemplate.POST.models.User;
import platform.codingnomads.co.springweb.resttemplate.POST.models.UserData;

@SpringBootApplication
public class postForObjectMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(postForObjectMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            //Sample
            /*Task newTask = Task.builder()
                    .name("learn how to use postForObject()")
                    .description("get comfortable using the RestTemplate postForObject() method")
                    .userId(5)
                    .completed(false)
                    .build();

            ResponseObject taskReturnedByServerAfterPost = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/tasks", newTask, ResponseObject.class);

            if (taskReturnedByServerAfterPost != null) {
                System.out.println(taskReturnedByServerAfterPost);
            }*/
            UserData newUser = UserData.builder()
                    .id(4)
                    .email("new email")
                    .first_name("Bob")
                    .last_name("Melburg")
                    .build();

            User userReturnedAfterPost = restTemplate
                    .postForObject("http://demo.codingnomads.co:8080/tasks_api/users", newUser, User.class);

            if (userReturnedAfterPost != null) {
                System.out.println(userReturnedAfterPost);
            }
        };
    }
}
