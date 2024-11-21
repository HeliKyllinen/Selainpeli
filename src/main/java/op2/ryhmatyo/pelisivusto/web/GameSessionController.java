package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.GameSession;
import op2.ryhmatyo.pelisivusto.domain.GameSessionRepository;
import op2.ryhmatyo.pelisivusto.domain.User;
import op2.ryhmatyo.pelisivusto.domain.UserRepository;
import op2.ryhmatyo.pelisivusto.service.GameSessionService;

@RestController
public class GameSessionController {

    @Autowired
    private GameSessionRepository gamesessionrepository;

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private GameSessionService gameSessionService;

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

    // Laskuri paikalla oleville pelaajille

    @GetMapping("/onlinePlayers")
    public ResponseEntity<Long> getOnlinePlayers() {
        Long onlinePlayers = gamesessionrepository.countByStatus("online");
        return ResponseEntity.ok(onlinePlayers);
    }

    // ID:n avulla löytää pelaajia ja niiden statukset

    @GetMapping("/find")
    public Optional<GameSession> findGameSession(@RequestParam Long userId, @RequestParam String status) {
        User user = userrepository.findByUser_id(userId);
        return gameSessionService.findGameSessionByUserAndStatus(user, status);
    }

    // Pelaajan status on online, kun peli alkaa

    @PostMapping("/startGame")
    public ResponseEntity<?> startGame(@RequestBody User user) {
        Optional<GameSession> existingSession = gamesessionrepository.findByUserAndStatus(user, "online");
        if (existingSession.isEmpty()) {
            GameSession gameSession = new GameSession();
            gameSession.setStatus("online");
            gameSession.setUser(user);
            gamesessionrepository.save(gameSession);
        }
        return ResponseEntity.ok().build();
    }

    // Pelaajan status on offline, kun peli loppuu

    @PostMapping("/endGame")
    public ResponseEntity<?> endGame(@RequestBody User user) {
        Optional<GameSession> session = gamesessionrepository.findByUserAndStatus(user, "online");
        if (session.isPresent()) {
            GameSession gameSession = session.get();
            gameSession.setStatus("offline");
            gamesessionrepository.save(gameSession);
        }
        return ResponseEntity.ok().build();
    }
}
