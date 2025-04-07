package repository;

import model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<Question, Long> {

}
