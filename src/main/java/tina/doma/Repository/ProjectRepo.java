package tina.doma.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tina.doma.Model.Project;

import java.util.List;

public interface ProjectRepo extends JpaRepository<Project, Long>{
//    List<Project> getProjectByInternId(Long id);
}
