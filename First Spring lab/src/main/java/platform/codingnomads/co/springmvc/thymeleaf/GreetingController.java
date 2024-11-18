package platform.codingnomads.co.springmvc.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    /*@GetMapping({ "/", "/index" })
    public String index(Model model) {
        model.addAttribute("name", "Spring Developer!");
        return "greeting"; 
    }*/
    @GetMapping({ "/", "/index" })
    public String index2(Model model) {
        model.addAttribute("user", "Kevin");
        model.addAttribute("country", "France");
        model.addAttribute("computer", "laptop");
        return "practice";
    }
}