package op2.ryhmatyo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        return "index"; // Oletetaan, että index.html on templates-kansiossa
    }
}