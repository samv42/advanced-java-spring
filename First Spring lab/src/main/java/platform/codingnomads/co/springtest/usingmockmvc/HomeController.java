package platform.codingnomads.co.springtest.usingmockmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Bobbert");
        return "greeting";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String greet() {
        return "Hello Back";
    }

    @GetMapping("/car")
    @ResponseBody
    public String getCar(){Car car = Car.builder()
            .brand("Toyota")
            .color("black")
            .model("Corolla")
            .build();
            return car.toString();
    }
    @GetMapping("/albert")
    public String returnAlbert(Model model) {
        model.addAttribute("name", "Albert");
        return "greeting";
    }

    @GetMapping("/empty")
    public String emptyModel(Model model) {
        return "greeting";
    }

}
