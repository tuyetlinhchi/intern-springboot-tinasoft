package tina.doma.Repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tina.doma.Model.Mentor;

public interface MentorRepo extends JpaRepository<Mentor, Long> {

}
