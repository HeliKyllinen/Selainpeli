package op2.ryhmatyo.pelisivusto.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface GameSessionRepository extends CrudRepository<GameSession, Long> {
    Long countByStatus(String status);

    Optional<GameSession> findByUserAndStatus(User user, String status);
}
