package by.itacademy.service;

import by.itacademy.entity.Client;
import by.itacademy.entity.ClientGymProgram;
import by.itacademy.entity.GymProgram;
import by.itacademy.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        Iterable<Client> clients = clientRepository.findAll();
        List<Client> values = new ArrayList<>();
        clients.forEach(values::add);
        return values;
    }

    public List<Client> findAllByNameLike(String name){
        return clientRepository.findAllByNameLike(name);
    }

    public List<Client> findAllByGymProgramsAndClientGymPrograms(Set<GymProgram> gymProgram, Set<ClientGymProgram> clientGymProgram,
                                                        Pageable pageable){
        return clientRepository.findAllByGymProgramsAndClientGymPrograms(gymProgram, clientGymProgram, pageable);
    }

    public int updateClient(Integer count, String name){
        return clientRepository.updateClient(count,name);
    }

    public void deleteById(Long id){
         clientRepository.deleteById(id);
    }
}
