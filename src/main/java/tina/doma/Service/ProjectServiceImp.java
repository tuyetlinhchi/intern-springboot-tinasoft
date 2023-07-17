package tina.doma.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tina.doma.Model.Project;
import tina.doma.Repository.ProjectRepo;

import java.util.Optional;

@Service
public class ProjectServiceImp implements IGeneralService<Project>{
    @Autowired
    private ProjectRepo projectRepository;

    @Override
    public Iterable<Project> findAll() {
        return projectRepository.findAll();
    }
    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }
    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }
    @Override
    public void remove(Long id){
        projectRepository.deleteById(id);
    }
}
