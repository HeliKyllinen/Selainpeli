package op2.ryhmatyo.pelisivusto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("headbreaker") // TÄMÄ ENDPOINT EI OLE KÄYTÖSSÄ, EI POISTETA KOSKA AIHEUTTAA BUGIN
    public String headbreaker(Model model) {
        model.addAttribute("image", imagerepository.findAll());
        return "headbreaker";
    }

    @RequestMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("errorMessage", "Virheellinen käyttäjätunnus tai salasana.");
        }
        return "login";
    }
}
