package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.Game;
import op2.ryhmatyo.pelisivusto.domain.GameRepository;

@RestController
public class GameController {

    @Autowired
    private GameRepository gamerepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/games", method = RequestMethod.GET)
    public List<Game> GameListRest() {
        return (List<Game>) gamerepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä pelistä

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public Optional<Game> findGameRest(@PathVariable("id") Long game_id) {
        return gamerepository.findById(game_id);
    }

}
