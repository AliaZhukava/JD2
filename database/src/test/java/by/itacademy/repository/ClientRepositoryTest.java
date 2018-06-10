package by.itacademy.repository;

import by.itacademy.config.TestConfig;
import by.itacademy.entity.Client;
import by.itacademy.entity.enum_entity.GymUserRole;
import by.itacademy.util.DatabaseHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public class ClientRepositoryTest {

    @Autowired
    private DatabaseHelper databaseHelper;

    @Autowired
    private ClientRepository clientRepository;

    @Before
    public void begin() {
        databaseHelper.init();
    }

    @Test
    public void checkSave(){
        Client savedClient = clientRepository.save(new Client("login10", "pass1", GymUserRole.USER, "name10",
                375291000000L, "email10", 0));
        assertThat(savedClient.getName(). equalTo("name10"));
    }

    @Test
    public void checkFindAll(){
        Iterable<Client> clients = clientRepository.findAll();
        List<Client> values = new ArrayList<>();
        clients.forEach(values::add);
        final int expectedSize = 6;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkFindAllByNameLike(){
        Iterable<Client> clients = clientRepository.findAllByNameLike("user%");
        List<Client> values = new ArrayList<>();
        clients.forEach(values::add);
        final int expectedSize = 5;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkFindAllByGymProgramsAndClientGymPrograms() {
        Iterable<Client> clients = clientRepository.findAllByGymProgramsAndClientGymPrograms(program1,clientGymProgram1, PageRequest.of(0, 2));
        List<Client> values = new ArrayList<>();
        clients.forEach(values::add);
        final int expectedSize = 2;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkDelete(){
        clientRepository.delete(user1);
        Iterable<Client> clients = clientRepository.findAll();
        List<Client> values = new ArrayList<>();
        clients.forEach(values::add);
        final int expectedSize = 5;
        assertThat(values, hasSize(expectedSize));
    }

    @Test
    public void checkUpdate(){
        int actual = clientRepository.updateClient(100, "user1");
        final int expected = 1;
        assertEquals(expected, actual);
    }
}
