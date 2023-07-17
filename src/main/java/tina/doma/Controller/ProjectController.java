package tina.doma.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tina.doma.Model.Project;
import tina.doma.Service.ProjectServiceImp;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectServiceImp projectServiceImp;

    @GetMapping
    public ResponseEntity<Iterable<Project>> getAllProjects() {
        return new ResponseEntity<>(projectServiceImp.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project){
        return new ResponseEntity<>(projectServiceImp.save(project), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Optional<Project> projectOptional = projectServiceImp.findById(id);
        return projectOptional.map(project -> new ResponseEntity<>(project, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project){
        Optional<Project> projectOptional = projectServiceImp.findById(id);
        return projectOptional.map(projects -> {
            project.setId(projects.getId());
            return new ResponseEntity<>(projectServiceImp.save(project), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Project> deleteProject(@PathVariable Long id){
        Optional<Project> projectOptional = projectServiceImp.findById(id);
        return projectOptional.map(project -> {
            projectServiceImp.remove(id);
            return new ResponseEntity<>(project, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
