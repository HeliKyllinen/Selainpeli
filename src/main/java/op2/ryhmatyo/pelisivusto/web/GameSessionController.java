package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.GameSession;
import op2.ryhmatyo.pelisivusto.domain.GameSessionRepository;

@RestController
public class GameSessionController {

    @Autowired
    private GameSessionRepository gamesessionrepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/gamesessions", method = RequestMethod.GET)
    public List<GameSession> GameSessionListRest() {
        return (List<GameSession>) gamesessionrepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä pelisessiosta

    @RequestMapping(value = "/gamesession/{id}", method = RequestMethod.GET)
    public Optional<GameSession> findGameSessionRest(@PathVariable("id") Long gameSession_id) {
        return gamesessionrepository.findById(gameSession_id);
    }
}
