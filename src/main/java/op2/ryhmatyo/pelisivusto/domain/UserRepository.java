package op2.ryhmatyo.pelisivusto.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.user_id = :user_id")
    User findByUser_id(@Param("user_id") Long user_id);
}
