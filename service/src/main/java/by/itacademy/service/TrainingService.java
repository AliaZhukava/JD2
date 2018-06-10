package by.itacademy.service;

import by.itacademy.entity.Training;
import by.itacademy.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrainingService {

    public final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training save(Training training){
        return trainingRepository.save(training);
    }

    public List<Training> findAll() {
        Iterable<Training> trainings = trainingRepository.findAll();
        List<Training> values = new ArrayList<>();
        trainings.forEach(values::add);
        return values;
    }

    public void deleteById(Long id){
        trainingRepository.deleteById(id);
    }
}
