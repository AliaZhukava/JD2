package by.itacademy.repository;

import by.itacademy.entity.Training;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends CrudRepository<Training, Long> {

    <S extends Training> S save(S entity);

    List<Training> findAll(Pageable pageable);

    void delete(Training entity);
}
