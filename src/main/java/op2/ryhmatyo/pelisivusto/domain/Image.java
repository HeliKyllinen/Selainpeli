package op2.ryhmatyo.pelisivusto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String image_path; // Polku tai URL kuvaan.

    @Column
    private String description; // Kuvaus kuvaan liittyen (millä haettu).

    @OneToOne(mappedBy = "image")
    private Puzzle puzzle; // Yhteys palapeliin, jos kuva liittyy tiettyyn palapeliin.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return image_path;
    }

    public void setImagePath(String image_path) {
        this.image_path = image_path;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Puzzle getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Puzzle puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", image_path='" + image_path +
                ", description='" + description +
                ", puzzle=" + (puzzle != null ? puzzle.getId() : "null") +
                '}';
    }
}
