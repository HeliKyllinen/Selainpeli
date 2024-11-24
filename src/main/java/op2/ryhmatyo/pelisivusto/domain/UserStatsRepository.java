package op2.ryhmatyo.pelisivusto.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserStatsRepository extends CrudRepository<UserStats, Long> {
    UserStats findByUserStatsId(Long UserStatsId);
    
    UserStats findByAverageTime(double averageTime);

    UserStats findByPuzzlesSolved(int puzzlesSolved);
    
}