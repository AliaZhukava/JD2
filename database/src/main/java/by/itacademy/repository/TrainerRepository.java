package by.itacademy.repository;

import by.itacademy.entity.Trainer;
import by.itacademy.entity.enum_entity.Category;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long> {

    <S extends Trainer> S save(S entity);

    List<Trainer> findAll(Pageable pageable);

    List<Trainer> findAllByCategory(Category category);

    List<Trainer> findAllByGymPrograms(String name, Pageable pageable);

    void delete(Trainer entity);

    @Modifying
    @Query("update Trainer t set t.category = :tCat where t.name = :tName")
    Category updateTrainer(@Param("tCat") Category category, @Param("tName") String name);
}
