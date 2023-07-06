package tina.doma.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tina.doma.Model.Intern;
import tina.doma.Service.InternServiceImp;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class InternController {
    @Autowired
    private InternServiceImp internServiceImp;
    @GetMapping
    public ResponseEntity<Iterable<Intern>> getAllIntern() {
        return new ResponseEntity<>(internServiceImp.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Intern> addIntern(@RequestBody Intern intern){
        return new ResponseEntity<>(internServiceImp.save(intern), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Intern> getIntern(@PathVariable Long id) {
        Optional<Intern> internOptional = internServiceImp.findById(id);
        return internOptional.map(intern -> new ResponseEntity<>(intern, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Intern> updateIntern(@PathVariable Long id, @RequestBody Intern intern){
        Optional<Intern> internOptional = internServiceImp.findById(id);
        return internOptional.map(interns -> {
            intern.setId(interns.getId());
            return new ResponseEntity<>(internServiceImp.save(intern), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Intern> deleteIntern(@PathVariable Long id){
        Optional<Intern> internOptional = internServiceImp.findById(id);
        return internOptional.map(intern -> {
            internServiceImp.remove(id);
            return new ResponseEntity<>(intern, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
