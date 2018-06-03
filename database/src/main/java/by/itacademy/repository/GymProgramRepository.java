package by.itacademy.repository;

import by.itacademy.entity.GymProgram;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymProgramRepository extends CrudRepository<GymProgram, Long> {

    <S extends GymProgram> S save(S entity);

    List<GymProgram> findAll(Pageable pageable);

    List<GymProgram> findAllByTrainerNameLike(String name);

    void delete(GymProgram entity);

    @Modifying
    @Query("update GymProgram p set p.cost = :pCost where p.name = :pName")
    int updateGymProgram(@Param("pCost") Integer count, @Param("pName") String name);
}
