package tina.doma.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tina.doma.Model.Mentor;
import tina.doma.Repository.MentorRepo;

import java.util.Optional;

@Service
public class MentorServiceImp implements IGeneralService<Mentor>{

    @Autowired
    private MentorRepo mentorRepository;
    @Override
    public Iterable<Mentor> findAll() {
        return mentorRepository.findAll();
    }
    @Override
    public Optional<Mentor> findById(Long id) {
        return mentorRepository.findById(id);
    }

    @Override
    public Mentor save(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public void remove(Long id) {
        mentorRepository.deleteById(id);
    }
}
