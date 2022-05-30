package com.dgtfactory.dgtfactoryassignment.client;

import com.dgtfactory.dgtfactoryassignment.shared.exceptions.ObjectWithIdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Client getById(Long id) {
        return this.repository
                .findById(id)
                .orElseThrow(() ->
                        new ObjectWithIdNotFoundException(id, "Client"));
    }

    @Override
    public Client save(Client client) {
        return this.repository.save(client);
    }

    @Override
    public Client update(Client client, Long id) {
        return this.repository
                .findById(id)
                .map(old -> {
                    old.setName(client.getName());
                    old.setSurname(client.getSurname());
                    return this.repository.save(old);
                })
                .orElseThrow(() ->
                        new ObjectWithIdNotFoundException(id, "Client"));
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(this.repository.getById(id));
    }
}
