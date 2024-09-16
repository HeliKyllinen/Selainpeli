package op2.ryhmatyo.pelisivusto.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_seq")
    @SequenceGenerator(name = "game_seq", sequenceName = "game_seq", allocationSize = 1)
    private Long game_id;

    @Column(name = "game_name")
    private String gameName;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<GameSession> gamesession = new ArrayList<>();

    public Game() {

    }

    public Game(String gameName, String description) {
        this.gameName = gameName;
        this.description = description;
    }

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
    }

    public String getgameName() {
        return gameName;
    }

    public void setgameName(String gameName) {
        this.gameName = gameName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<GameSession> getGamesession() {
        return gamesession;
    }

    public void setGamesession(List<GameSession> gamesession) {
        this.gamesession = gamesession;
    }

    @Override
    public String toString() {
        return "Game [gameName=" + gameName + ", description=" + description + ", gamesession=" + gamesession + "]";
    }

}
