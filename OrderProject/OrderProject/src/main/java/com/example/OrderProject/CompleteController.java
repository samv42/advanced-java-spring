package com.example.OrderProject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompleteController {

    private final CompleteService completeService;

    public CompleteController(CompleteService completeService) {
        this.completeService = completeService;
    }

    @GetMapping("/Completed")
    public String Complete () {
        return completeService.completeStatus();
    }
}
