package com.example.OrderProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusController {
    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/Recieved")
    public String orderPending () {
        return statusService.processStatus(true);
    }

    @GetMapping("/Delivered")
    public String orderReceived () {
        return statusService.processStatus(false);
    }
}
