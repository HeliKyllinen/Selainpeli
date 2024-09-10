package op2.ryhmatyo.pelisivusto.domain;

import jakarta.persistence.Entity;

@Entity
public class GameSession {

    private Long gameSession_id;

    private User user;

    private Game game;

    private String status;

    public GameSession(Long gameSession_id, User user, Game game, String status) {
        this.gameSession_id = gameSession_id;
        this.user = user;
        this.game = game;
        this.status = status;
    }

    public GameSession(){

    }

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
                ", status='" + status + '\'' +
                '}';
    }
    
}
