package by.itacademy.repository;

import by.itacademy.entity.ClientGymProgram;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientGymProgramRepository extends CrudRepository<ClientGymProgram, Long> {

}
