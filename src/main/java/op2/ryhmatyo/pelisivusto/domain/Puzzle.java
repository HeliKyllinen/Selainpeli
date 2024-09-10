package op2.ryhmatyo.pelisivusto.domain;

import java.time.LocalDate;

public class Puzzle {

    private Long puzzle_id;

    private GameSession gamesession;

    private Piece piece;

    private Image image;

    private int pieceCount;

    private LocalDate createDate;

    public Puzzle(Long puzzle_id, GameSession gamesession, Piece piece, Image image, int pieceCount, LocalDate createDate) {
        this.puzzle_id = puzzle_id;
        this.gamesession = gamesession;
        this.piece = piece;
        this.image = image;
        this.pieceCount = pieceCount;
        this.createDate = createDate;
    }
    
    public Puzzle() {

    }

    public Long getPuzzle_id() {
        return puzzle_id;
    }

    public void setPuzzle_id(Long getPuzzle_id) {
        this.puzzle_id = puzzle_id;
    }

    public GameSession getGamesession() {
        return gamesession;
    }

    public void setGamesession(GameSession gamesession) {
        this.gamesession = gamesession;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
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
