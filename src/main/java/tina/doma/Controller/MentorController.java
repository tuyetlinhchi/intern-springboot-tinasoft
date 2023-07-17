package tina.doma.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tina.doma.Model.Mentor;
import tina.doma.Service.MentorServiceImp;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/mentor")
public class MentorController {

    @Autowired private MentorServiceImp mentorServiceImp;

    @GetMapping
    public ResponseEntity<Iterable<Mentor>> getAllMentors() {
        return new ResponseEntity<>(mentorServiceImp.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Mentor> addMentor(@RequestBody Mentor mentor){
        return new ResponseEntity<>(mentorServiceImp.save(mentor), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Mentor> getMentor(@PathVariable Long id) {
        Optional<Mentor> mentorOptional = mentorServiceImp.findById(id);
        return mentorOptional.map(mentor -> new ResponseEntity<>(mentor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable Long id, @RequestBody Mentor mentor){
        Optional<Mentor> mentorOptional = mentorServiceImp.findById(id);
        return mentorOptional.map(mentors -> {
            mentor.setId(mentors.getId());
            return new ResponseEntity<>(mentorServiceImp.save(mentor), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Mentor> deleteMentor(@PathVariable Long id){
        Optional<Mentor> mentorOptional = mentorServiceImp.findById(id);
        return mentorOptional.map(mentor -> {
            mentorServiceImp.remove(id);
            return new ResponseEntity<>(mentor, HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
