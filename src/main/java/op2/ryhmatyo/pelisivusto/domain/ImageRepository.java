package op2.ryhmatyo.pelisivusto.domain;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
   
}
