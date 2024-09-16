package op2.ryhmatyo.pelisivusto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    @SequenceGenerator(name = "image_seq", sequenceName = "image_seq", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String imageUrl; // Polku tai URL kuvaan.

    @Column
    private String description; // Kuvaus kuvaan liittyen (millä haettu).

    @OneToMany(mappedBy = "image", cascade = CascadeType.ALL)
    private List<Puzzle> puzzle = new ArrayList<>(); // Yhteys palapeliin, jos kuva liittyy tiettyyn palapeliin.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagePath() {
        return imageUrl;
    }

    public void setImagePath(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Puzzle> getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(List<Puzzle> puzzle) {
        this.puzzle = puzzle;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", imageUrl='" + imageUrl +
                ", description='" + description +
                ", puzzle=" + (puzzle != null /* ?puzzle.get() : "null" */ ) +
                '}';
    }
}
