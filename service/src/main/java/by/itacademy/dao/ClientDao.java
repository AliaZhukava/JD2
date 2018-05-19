package by.itacademy.dao;

import by.itacademy.entity.Client;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ClientDao extends BaseDao implements DaoInterface<Client, Long> {

    public final static ClientDao INSTANCE = new ClientDao();

    public static ClientDao getInstance() {
        return INSTANCE;
    }

    @Override
    public Long save(Client entity) {
        return (Long)getCurrentSession().save(entity);
    }

    @Override
    public void update(Client entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public Client findById(Long id) {
        Client client = getCurrentSession().get(Client.class, id);
        return client;
    }

    @Override
    public void delete(Client entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = getCurrentSession().createQuery("from Client").list();
        return clients;
    }
}
