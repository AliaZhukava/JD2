package by.itacademy.service;

import by.itacademy.entity.ClientGymProgram;
import by.itacademy.repository.ClientGymProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientGymProgramService {

    private final ClientGymProgramRepository clientGymProgramRepository;

    @Autowired
    public ClientGymProgramService(ClientGymProgramRepository clientGymProgramRepository) {
        this.clientGymProgramRepository = clientGymProgramRepository;
    }

    public ClientGymProgram save(ClientGymProgram clientGymProgram){
        return clientGymProgramRepository.save(clientGymProgram);
    }

    public void deleteById(Long id){
        clientGymProgramRepository.deleteById(id);
    }
}
