package op2.ryhmatyo.pelisivusto.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Game {

    @Id
    private Long game_id;

    private String game_name;

    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<GameSession> gamesession = new ArrayList<>();

    public Game() {

    }

    public Game(String game_name, String description) {
        this.game_name = game_name;
        this.description = description;
    }

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
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
        return "Game [game_name=" + game_name + ", description=" + description + ", gamesession=" + gamesession + "]";
    }

}
