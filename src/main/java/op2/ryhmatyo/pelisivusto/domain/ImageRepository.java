package op2.ryhmatyo.pelisivusto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
    List<Image> findBySearchQuery(String searchQuery);
}
