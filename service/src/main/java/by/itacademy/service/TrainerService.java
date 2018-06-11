package by.itacademy.service;

import by.itacademy.entity.Trainer;
import by.itacademy.entity.enum_entity.Category;
import by.itacademy.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrainerService {

    public final TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }

    public List<Trainer> findAll() {
        Iterable<Trainer> trainers = trainerRepository.findAll();
        List<Trainer> values = new ArrayList<>();
        trainers.forEach(values::add);
        return values;
    }

    public List<Trainer> findAllByCategory(Category category){
        return trainerRepository.findAllByCategory(category);
    }

    public List<Trainer> findAllByGymPrograms(String name, Pageable pageable){
        return trainerRepository.findAllByGymPrograms(name, pageable);
    }

    public Category updateTrainer(Category category, String name) {
        return trainerRepository.updateTrainer(category, name);
    }

    public void deleteById(Long id) {
        trainerRepository.deleteById(id);
    }
}
