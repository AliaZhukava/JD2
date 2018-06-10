package by.itacademy.repository;

import by.itacademy.entity.Client;
import by.itacademy.entity.ClientGymProgram;
import by.itacademy.entity.GymProgram;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    List<Client> findAllByNameLike(String name);

    Client findByName(String name);

    List<Client> findAllByGymProgramsAndClientGymPrograms(Set<GymProgram> gymProgram, Set<ClientGymProgram> clientGymProgram,
                                                          Pageable pageable);

    @Modifying
    @Query("update Client c set c.bonusCount = :bCount where c.name = :cName")
    int updateClient(@Param("bCount") Integer count, @Param("cName") String name);

}
