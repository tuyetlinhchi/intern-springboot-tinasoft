package tina.doma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tina.doma.Model.Intern;

public interface InternRepo extends JpaRepository<Intern, Long> {
}
