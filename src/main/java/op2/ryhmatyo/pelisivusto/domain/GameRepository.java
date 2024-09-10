package op2.ryhmatyo.pelisivusto.domain;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
    Game findByGamename(String game_name);
}
