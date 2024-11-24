package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.UserStats;
import op2.ryhmatyo.pelisivusto.domain.UserStatsRepository;

@RestController
public class UserStatsController {

    @Autowired
    private UserStatsRepository userStatsRepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/userstats", method = RequestMethod.GET)
    public List<UserStats> UserStatsListRest() {
        return (List<UserStats>) userStatsRepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietyn käyttäjän tilastoista

    @RequestMapping(value = "/userstats/{id}", method = RequestMethod.GET)
    public Optional<UserStats> findUserStatsRest(@PathVariable("id") Long userStatsId) {
        System.out.println("Received ID: " + userStatsId);
        return userStatsRepository.findById(userStatsId);
    }

    // Käyttäjän tilastojen lisääminen tietokantaan

    @RequestMapping(value = "/userstats", method = RequestMethod.POST)
    public UserStats addUserStats(@RequestBody UserStats userStats) {
        return userStatsRepository.save(userStats);

    }

    // Käyttäjän tilastojen nollaaminen tietokannasta

    @RequestMapping(value = "/userstats/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUserStats(@PathVariable("id") Long UserStatsId) {
        Optional<UserStats> userStats = userStatsRepository.findById(UserStatsId);
        if (userStats.isPresent()) {
            userStatsRepository.deleteById(UserStatsId);
            return new ResponseEntity<>("Käyttäjän tilastot on poistettu.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Käyttäjän tilastoja ei löytynyt.", HttpStatus.NOT_FOUND);
        }
    }
}
