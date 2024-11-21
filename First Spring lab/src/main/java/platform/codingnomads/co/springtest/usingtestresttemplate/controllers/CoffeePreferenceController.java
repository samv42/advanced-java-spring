package platform.codingnomads.co.springtest.usingtestresttemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import platform.codingnomads.co.springtest.usingtestresttemplate.models.CoffeePreference;
import platform.codingnomads.co.springtest.usingtestresttemplate.services.CoffeePreferenceService;

@Controller
@RequestMapping("/coffee")
public class CoffeePreferenceController {

    @Autowired
    CoffeePreferenceService service;

    @PostMapping
    public ResponseEntity<?> postNewCoffeePreference(@RequestBody CoffeePreference coffeePreference) {
        try {
            CoffeePreference preference = service.insertNewCoffeePreference(coffeePreference);
            return ResponseEntity.ok().header("Location","http://www.url.com/new/location").body(preference);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(new Exception(e.getMessage()));
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCoffeePreference(@PathVariable(name = "id") Long id) {
        try {
            CoffeePreference preference = service.getCoffeePreferenceById(id);
            return ResponseEntity.ok().header("Location","http://www.url.com/new/location").body(preference);
        }catch (Exception e) {
            return ResponseEntity.status(500).body(new Exception(e.getMessage()));
        }
    }
}
