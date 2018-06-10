package by.itacademy.repository;

import by.itacademy.entity.Training;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {

}
