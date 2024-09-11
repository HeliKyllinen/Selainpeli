package op2.ryhmatyo.pelisivusto.domain;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface PieceRepository extends CrudRepository<Piece, Long> {
   
}