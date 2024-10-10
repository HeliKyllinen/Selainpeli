package op2.ryhmatyo.pelisivusto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import op2.ryhmatyo.pelisivusto.domain.Image;
import op2.ryhmatyo.pelisivusto.domain.ImageRepository;

@Controller
public class MainController {

    @Autowired
    private ImageRepository imagerepository;

    @RequestMapping("home")
    public String home(Model model) {
        model.addAttribute("image", imagerepository.findAll());
        return "index";
    }

    @RequestMapping("headbreaker")
    public String headbreaker(Model model) {
        model.addAttribute("image", imagerepository.findAll());
        return "headbreaker";
    }

    @GetMapping("/") // Juuripolku
    public String index() {
        return "index";
    }

}