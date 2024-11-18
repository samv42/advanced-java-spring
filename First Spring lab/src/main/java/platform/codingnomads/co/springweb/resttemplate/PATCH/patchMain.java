package platform.codingnomads.co.springweb.resttemplate.PATCH;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.ResponseObject;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.Task;
import platform.codingnomads.co.springweb.resttemplate.PATCH.models.UserResponse;


import java.util.Objects;

@SpringBootApplication
public class patchMain {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(patchMain.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        HttpClient client = HttpClients.createDefault();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));
        return restTemplate;
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {

            //create an empty Task
            /*Task task = new Task();

            //set fields for identification
            task.setId(6);

            //set fields you want to change. All other fields are null and will not be updated
            task.setName("use patchForObject()");
            task.setDescription("this task was updated using patchForObject()");

            //send the PATCH request using the URL, the Task created above and the ResponseObject Class
            ResponseObject objectResponse = restTemplate
                    .patchForObject("http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(), task, ResponseObject.class);

            System.out.println(Objects.requireNonNull(objectResponse));

            task.setName("PATCH using exchange()");
            task.setDescription("This task was updated using PATCH");

            HttpEntity<Task> httpEntity = new HttpEntity<>(task);
            ResponseEntity<ResponseObject> response = restTemplate
                    .exchange("http://demo.codingnomads.co:8080/tasks_api/tasks/" + task.getId(), HttpMethod.PATCH, httpEntity, ResponseObject.class);

            System.out.println(Objects.requireNonNull(response));*/

            User user = new User();
            user.setId(425);
            user.setFirst_name("Collin");
            user.setLast_name("Eblaire");
            UserResponse data = new UserResponse();
            data.setData(user);

            UserResponse objectResponse2 = restTemplate.patchForObject("http://demo.codingnomads.co:8080/tasks_api/users/" + user.getId(),
                    data, UserResponse.class);
            System.out.println(Objects.requireNonNull(objectResponse2));

            user.setFirst_name("Collinn");
            user.setLast_name("Eblair");

            HttpEntity<User> httpEntity2 = new HttpEntity<>(user);
            ResponseEntity<UserResponse> response2 = restTemplate.exchange("http://demo.codingnomads.co:8080/tasks_api/users/" + user.getId(),
                    HttpMethod.PATCH, httpEntity2, UserResponse.class);
            System.out.println(Objects.requireNonNull(response2));

        };
    }
}
