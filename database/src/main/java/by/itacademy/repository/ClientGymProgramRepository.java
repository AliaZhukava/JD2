package by.itacademy.repository;

import by.itacademy.entity.ClientGymProgram;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientGymProgramRepository extends CrudRepository<ClientGymProgram, Long> {

    <S extends ClientGymProgram> S save(S entity);

    List<ClientGymProgram> findAll(Pageable pageable);

    void delete(ClientGymProgram entity);
}
