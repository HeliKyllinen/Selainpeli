package op2.ryhmatyo.pelisivusto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class UserStats {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userStats_seq")
    @SequenceGenerator(name = "userStats_seq", sequenceName = "userStats_seq", allocationSize = 1)
    private Long userStatsId;

    private double averageTime;

    private int puzzlesSolved;

    public UserStats() {

    }

    public UserStats(double averageTime, int puzzlesSolved) {
        this.averageTime = averageTime;
        this.puzzlesSolved = puzzlesSolved;
    }

    public Long getUserStatsId() {
        return userStatsId;
    }

    public void setUserStatsId(Long userStatsId) {
        this.userStatsId = userStatsId;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(double averageTime) {
        this.averageTime = averageTime;
    }

    public int getPuzzlesSolved() {
        return puzzlesSolved;
    }

    public void setPuzzlesSolved(int puzzlesSolved) {
        this.puzzlesSolved = puzzlesSolved;
    }

    @Override
    public String toString() {
        return "UserStats [userStatsId=" + userStatsId + ", averageTime=" + averageTime + ", puzzlesSolved=" + puzzlesSolved + "]";
    }

}
