package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.Role;
import op2.ryhmatyo.pelisivusto.domain.RoleRepository;

@RestController
public class RoleController {

    @Autowired
    private RoleRepository rolerepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<Role> RoleListRest() {
        return (List<Role>) rolerepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä roolista

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public Optional<Role> findRoleRest(@PathVariable("id") Long role_id) {
        return rolerepository.findById(role_id);
    }

}