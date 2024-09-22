package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.User;
import op2.ryhmatyo.pelisivusto.domain.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userrepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> UserListRest() {
        return (List<User>) userrepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä käyttäjästä

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Optional<User> findUserRest(@PathVariable("id") Long user_id) {
        return userrepository.findById(user_id);
    }

}