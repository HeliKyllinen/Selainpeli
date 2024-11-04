package op2.ryhmatyo.pelisivusto.domain;

//import java.util.ArrayList;
//import java.util.List;

//import com.fasterxml.jackson.annotation.JsonIgnore;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;
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

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    /*@JsonIgnore
    @OneToMany(mappedBy = "gamesession", cascade = CascadeType.ALL)
    private List<Puzzle> puzzle = new ArrayList<>();*/

    private String status;

    public GameSession() {

    }

    public GameSession(String status) {
        this.status = status;
    }

    /*public List<Puzzle> getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(List<Puzzle> puzzle) {
        this.puzzle = puzzle;
    }*/

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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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
                ", game=" + game +
                ", status=" + status +
                //", puzzle=" +  puzzle + '\'' +
                '}';
    }

}


