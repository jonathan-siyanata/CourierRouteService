package za.co.jaliatechnologies.accessingdatawithmysql.service;

import za.co.jaliatechnologies.accessingdatawithmysql.dto.ClientDto;

import java.util.List;

/**
 * The interface Client service.
 */
public interface ClientService {

    /**
     * Reads all the clients
     *
     * @return a list of all the clients
     */
    List<ClientDto> readAllClients();

    /**
     * Creates a clients details
     *
     * @param clientDto of the required information to create a client
     * @return the ClientDto which consists of a the clients information
     */
    ClientDto createClient(ClientDto clientDto);

    /**
     * Deletes a specific address associated  with a specific ID
     *
     * @param clientId of the client
     */
    void deleteClient(Long clientId);

    /**
     * Updates a specific client associated  with a specific ID
     *
     * @param clientId of the client
     * @return the ClientDto which contains the updated information
     */
    ClientDto updateClient(ClientDto clientId);

    /**
     * Client is associated to a specific delivery by ID
     *
     * @param clientId of the client
     * @return the ClientDto with contains client information required for to make the delivery
     */
    ClientDto delivery(Long clientId);
}
