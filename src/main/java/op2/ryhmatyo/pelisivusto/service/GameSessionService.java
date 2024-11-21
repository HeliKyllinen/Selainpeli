package op2.ryhmatyo.pelisivusto.service;

import op2.ryhmatyo.pelisivusto.domain.GameSession;
import op2.ryhmatyo.pelisivusto.domain.User;
import op2.ryhmatyo.pelisivusto.domain.GameSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameSessionService {
    @Autowired
    private GameSessionRepository gameSessionRepository;

    public Optional<GameSession> findGameSessionByUserAndStatus(User user, String status) {
        return gameSessionRepository.findByUserAndStatus(user, status);
    }
}