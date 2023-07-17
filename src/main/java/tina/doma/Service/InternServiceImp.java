package tina.doma.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tina.doma.Model.Intern;
import tina.doma.Repository.InternRepo;

import java.util.Optional;
@Service
public class InternServiceImp implements IGeneralService<Intern> {
    @Autowired
    private InternRepo internRepository;

    @Override
    public Iterable<Intern> findAll() {
        return internRepository.findAll();
    }

    @Override
    public Optional<Intern> findById(Long id) {
        return internRepository.findById(id);
    }

    @Override
    public Intern save(Intern intern) {
        return internRepository.save(intern);
    }

    @Override
    public void remove(Long id) {
        internRepository.deleteById(id);
    }
}