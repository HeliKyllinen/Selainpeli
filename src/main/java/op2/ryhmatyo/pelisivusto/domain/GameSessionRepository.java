package op2.ryhmatyo.pelisivusto.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameSessionRepository extends JpaRepository<GameSession, Long> {
    Long countByStatus(String status);

    Optional<GameSession> findByUserAndStatus(User user, String status);
}

