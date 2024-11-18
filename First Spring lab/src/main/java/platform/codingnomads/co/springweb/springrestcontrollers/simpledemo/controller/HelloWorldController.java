package platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springweb.springrestcontrollers.simpledemo.Cat;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {

    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String hello() {
        return "Hello Spring Developer!";
    }

    @RequestMapping(path = "/hello/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String greeting(@PathVariable(name = "name") String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> getList(@PathVariable(name="number") Integer number){
        List<Integer> list = new ArrayList<Integer>();
        if(number<=0){
            list.add(number);
        }else {
            for (Integer i = 0; i < number; i++) {
                list.add(i);
            }
        }
        return list;
    }

    @RequestMapping(path = "/cat", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCat(){
        Cat cat = new Cat();
        cat.setName("Abigail");
        cat.setBreed("Tabby");
        cat.setColor("orange");
        cat.setSex("female");
        return cat.toString();
    }
}




