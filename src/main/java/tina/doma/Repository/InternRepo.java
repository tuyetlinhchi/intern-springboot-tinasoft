package tina.doma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tina.doma.Model.Intern;

import java.util.List;

public interface InternRepo extends JpaRepository<Intern, Long> {
//    List<Intern> getInternByMentorId(Long id);

}
