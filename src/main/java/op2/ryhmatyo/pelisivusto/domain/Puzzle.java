package op2.ryhmatyo.pelisivusto.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Puzzle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "puzzle_seq")
    @SequenceGenerator(name = "puzzle_seq", sequenceName = "puzzle_seq", allocationSize = 1)
    private Long puzzle_id;

    @ManyToOne
    @JoinColumn(name = "game_session_id")
    private GameSession gamesession;

    @JsonIgnore
    @OneToMany(mappedBy = "puzzle", cascade = CascadeType.ALL)
    private List<Piece> piece = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    private int pieceCount;

    private LocalDate createDate;

    public Puzzle(Image image, int pieceCount, LocalDate createDate) {
        this.image = image;
        this.pieceCount = pieceCount;
        this.createDate = createDate;
    }

    public Puzzle() {

    }

    public Long getPuzzle_id() {
        return puzzle_id;
    }

    public void setPuzzle_id(Long puzzle_id) {
        this.puzzle_id = puzzle_id;
    }

    public GameSession getGamesession() {
        return gamesession;
    }

    public void setGamesession(GameSession gamesession) {
        this.gamesession = gamesession;
    }

    public List<Piece> getPiece() {
        return piece;
    }

    public void setPiece(List<Piece> piece) {
        this.piece = piece;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getPieceCount() {
        return pieceCount;
    }

    public void setPieceCount(int pieceCount) {
        this.pieceCount = pieceCount;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Puzzle{" +
                "puzzle_id=" + puzzle_id +
                ", gamesession=" + gamesession +
                ", piece=" + piece +
                ", image=" + image +
                ", pieceCount=" + pieceCount +
                ", createDate=" + createDate +
                '}';
    }

}
