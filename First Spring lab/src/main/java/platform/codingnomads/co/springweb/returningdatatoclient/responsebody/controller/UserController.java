package platform.codingnomads.co.springweb.returningdatatoclient.responsebody.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import platform.codingnomads.co.springweb.returningdatatoclient.responsebody.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    public User user = User.builder()
            .id(1000)
            .name("Spring Dev")
            .email("dev@codingnomads.co")
            .build();
    public User user2 = User.builder()
            .id(2000)
            .name("Bob")
            .email("bob@gmail.com")
            .build();
    public User user3 = User.builder()
            .id(3000)
            .name("Jane")
            .email("jane@gmail.com")
            .build();
    public User user4 = User.builder()
            .id(4000)
            .name("Sarah")
            .email("sarah@gmail.com")
            .build();
    public List<User> list = Arrays.asList(user2, user3, user4);
    //using ResponseBody to return a POJO
    @ResponseBody
    @GetMapping("/response-body")
    public User userResponseBody() {
        return user;
    }

    //using ResponseEntity to return POJO
    @GetMapping("/response-entity")
    public ResponseEntity<User> userResponseEntity() {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //returning a POJO without ResponseBody or using a ResponseEntity
    @GetMapping("/user")
    public User user() {
        return user;
    }

    @ResponseBody
    @GetMapping("/user-list")
    public List<User> getList() {return list;}
}
