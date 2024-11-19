package op2.ryhmatyo.pelisivusto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import op2.ryhmatyo.pelisivusto.domain.ImageRepository;

@Controller
public class MainController {

    @Autowired
    private ImageRepository imagerepository;

    @RequestMapping(value = {"/", "home"})
    public String home(Model model) {
        model.addAttribute("image", imagerepository.findAll());
        return "index";
    }

    @RequestMapping("headbreaker")
    public String headbreaker(Model model) {
        model.addAttribute("image", imagerepository.findAll());
        return "headbreaker";
    }

    @RequestMapping("/login")
    public String login() {
        return "login"; 
    }
}
