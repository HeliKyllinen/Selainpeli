package op2.ryhmatyo.pelisivusto.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Piece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int position_x; // Palan alkuperäinen sijainti x-akselilla.

    @Column(nullable = false)
    private int position_y; // Palan alkuperäinen sijainti y-akselilla.

    @Column
    private Integer cur_position_x; // Palan nykyinen sijainti x-akselilla (jos liikkuu pelin aikana).

    @Column
    private Integer cur_position_y; // Palan nykyinen sijainti y-akselilla (jos liikkuu pelin aikana).

    @ManyToOne
    @JoinColumn(name = "puzzle_id", nullable = false)
    private Puzzle puzzle; // Viite palapeliin, johon pala kuuluu.

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPositionX() {
        return position_x;
    }

    public void setPositionX(int position_x) {
        this.position_x = position_x;
    }

    public int getPositionY() {
        return position_y;
    }

    public void setPositionY(int position_y) {
        this.position_y = position_y;
    }

    public Integer getCurrentPositionX() {
        return cur_position_x;
    }

    public void setCurrentPositionX(Integer cur_position_x) {
        this.cur_position_x = cur_position_x;
    }

    public Integer getCurrentPositionY() {
        return cur_position_y;
    }

    public void setCurrentPositionY(Integer cur_position_y) {
        this.cur_position_y = cur_position_y;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }


     @Override
    public String toString() {
        return "Piece{" +
                "id=" + id +
                ", position_x=" + position_x +
                ", position_y=" + position_y +
                ", cur_position_x=" + cur_position_x +
                ", cur_position_y=" + cur_position_y +
                ", puzzle=" + (puzzle != null ? puzzle.getId() : "null") +
                '}';
    }
}

