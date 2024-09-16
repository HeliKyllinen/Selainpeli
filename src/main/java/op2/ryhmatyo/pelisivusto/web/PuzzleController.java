package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.Puzzle;
import op2.ryhmatyo.pelisivusto.domain.PuzzleRepository;

@RestController
public class PuzzleController {

    @Autowired
    private PuzzleRepository puzzlerepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/puzzles", method = RequestMethod.GET)
    public List<Puzzle> PuzzleListRest() {
        return (List<Puzzle>) puzzlerepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä palapelistä

    @RequestMapping(value = "/puzzle/{id}", method = RequestMethod.GET)
    public Optional<Puzzle> findPuzzleRest(@PathVariable("id") Long puzzle_id) {
        return puzzlerepository.findById(puzzle_id);
    }

}
