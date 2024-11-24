package op2.ryhmatyo.pelisivusto.domain;
<<<<<<< Updated upstream

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
=======
>>>>>>> Stashed changes
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
<<<<<<< Updated upstream
import jakarta.persistence.OneToMany;
=======
>>>>>>> Stashed changes
import jakarta.persistence.SequenceGenerator;

@Entity
public class GameSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_session_seq")
    @SequenceGenerator(name = "game_session_seq", sequenceName = "game_session_seq", allocationSize = 1)
    private Long gameSession_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

<<<<<<< Updated upstream
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @JsonIgnore
    @OneToMany(mappedBy = "gamesession", cascade = CascadeType.ALL)
    private List<Puzzle> puzzle = new ArrayList<>();

=======
>>>>>>> Stashed changes
    private String status;

    public GameSession() {

    }

    public GameSession(String status) {
        this.status = status;
    }

<<<<<<< Updated upstream
    public List<Puzzle> getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(List<Puzzle> puzzle) {
        this.puzzle = puzzle;
    }

=======
>>>>>>> Stashed changes
    public Long getGameSession_id() {
        return gameSession_id;
    }

    public void setGameSession_id(Long GameSession_id) {
        this.gameSession_id = GameSession_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GameSession{" +
                "gameSessionId=" + gameSession_id +
                ", user=" + user +
                ", status=" + status +
<<<<<<< Updated upstream
                ", puzzle=" +  puzzle + '\'' +
=======
>>>>>>> Stashed changes
                '}';
    }

}


