package by.itacademy.service;

import by.itacademy.entity.GymProgram;
import by.itacademy.repository.GymProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GymProgramService {

    public final GymProgramRepository gymProgramRepository;

    @Autowired
    public GymProgramService(GymProgramRepository gymProgramRepository) {
        this.gymProgramRepository = gymProgramRepository;
    }

    public GymProgram save(GymProgram gymProgram){
        return gymProgramRepository.save(gymProgram);
    }

    public List<GymProgram> findAll() {
        Iterable<GymProgram> gymPrograms = gymProgramRepository.findAll();
        List<GymProgram> values = new ArrayList<>();
        gymPrograms.forEach(values::add);
        return values;
    }

    public List<GymProgram> findAllByTrainerNameLike(String name){
        return gymProgramRepository.findAllByTrainerNameLike(name);
    }

        public int updateGymProgram(Integer cost, String name){
        return gymProgramRepository.updateGymProgram(cost,name);
    }

    public void deleteById(Long id){
        gymProgramRepository.deleteById(id);
    }
}
