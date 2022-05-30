package com.dgtfactory.dgtfactoryassignment.client;

import java.util.List;

public interface ClientService {
    /**
     *
     * @return List of all clients
     */
    List<Client> getAll();

    /**
     *
     * @param id unique identificator used to get single client
     * @return single client
     */
    Client getById(Long id);

    /**
     *
     * @param client data to be saved
     * @return changed data of the client
     */
    Client save(Client client);

    /**
     *
     * @param client data to be changed
     * @param id identifier of which client data is going to be changed
     * @return changed client data
     */
    Client update(Client client, Long id);

    /**
     *
     * @param id identifier of client to be deleted
     */
    void delete(Long id);
}
