package op2.ryhmatyo.pelisivusto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import op2.ryhmatyo.pelisivusto.domain.Piece;
import op2.ryhmatyo.pelisivusto.domain.PieceRepository;

@RestController
public class PieceController {

    @Autowired
    private PieceRepository piecerepository;

    // Kaikki tiedot JSON-muodossa

    @RequestMapping(value = "/pieces", method = RequestMethod.GET)
    public List<Piece> PieceListRest() {
        return (List<Piece>) piecerepository.findAll();
    }

    // ID:n avulla haettavat tiedot tietystä palasta

    @RequestMapping(value = "/piece/{id}", method = RequestMethod.GET)
    public Optional<Piece> findPieceRest(@PathVariable("id") Long piece_id) {
        return piecerepository.findById(piece_id);
    }

}