package za.co.jaliatechnologies.accessingdatawithmysql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import za.co.jaliatechnologies.accessingdatawithmysql.dto.ClientDto;
import za.co.jaliatechnologies.accessingdatawithmysql.entity.Client;
import za.co.jaliatechnologies.accessingdatawithmysql.dao.ClientDao;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * The type Client service.
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    @Override
    public ClientDto createClient(ClientDto clientDto){

        Client creatingClient = new Client();

        creatingClient.setClient_id_number(clientDto.getClient_id_number());
        creatingClient.setFirst_name(clientDto.getFirst_name());
        creatingClient.setLast_name(clientDto.getLast_name());
        creatingClient.setDate_of_birth(clientDto.getDate_of_birth());
        creatingClient.setEmail_address(clientDto.getEmail_address());
        creatingClient.setPhone_number(clientDto.getPhone_number());
        creatingClient.setAddress_id(clientDto.getAddress_id());
        clientDao.save(creatingClient);
        System.out.println("Client Created!!");
        return clientDto;
    }

    @Override
    public List<ClientDto> readAllClients() {
        ClientDto clientDto = new ClientDto();
        List<Client> clientDtoList = (List<Client>) clientDao.findAll();
        List<ClientDto> clientDtoReturnList = new ArrayList(Arrays.asList(clientDtoList));
        return clientDtoReturnList;
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        Optional<Client> personOptional = this.clientDao.findById(clientDto.getClient_id());

        if(personOptional.isPresent()){
            Client updateClient = personOptional.get();
            updateClient.setFirst_name(clientDto.getFirst_name());
            updateClient.setLast_name(clientDto.getLast_name());
            updateClient.setDate_of_birth(clientDto.getDate_of_birth());
            updateClient.setEmail_address(clientDto.getEmail_address());
            updateClient.setPhone_number(clientDto.getPhone_number());
            updateClient.setClient_id_number(clientDto.getClient_id_number());
            updateClient.setAddress_id(clientDto.getAddress_id());
            clientDao.save(updateClient);
            System.out.println("Client has been successfully updated!!");
            return clientDto;
        }else{
            throw new ResourceNotFoundException("Client id : " + clientDto.getClient_id() + " not found");
        }
    }

    @Override
    public ClientDto delivery(Long clientId) {
        Optional<Client> delivery = this.clientDao.findById(clientId);
        ClientDto clientDto = new ClientDto();

        if(delivery.isPresent()){
            clientDto.setClient_id(delivery.get().getClient_id());
            clientDto.setFirst_name(delivery.get().getFirst_name());
            clientDto.setLast_name(delivery.get().getLast_name());
            clientDto.setDate_of_birth(delivery.get().getDate_of_birth());
            clientDto.setEmail_address(delivery.get().getEmail_address());
            clientDto.setPhone_number(delivery.get().getPhone_number());
            clientDto.setClient_id_number(delivery.get().getClient_id_number());
            return clientDto;

        }else{
            throw new ResourceNotFoundException("Client id : " + clientId + " not found");
        }
    }

    @Override
    public void deleteClient(Long clientId) {
        Optional<Client> personInDb = this.clientDao.findById(clientId);

        if(personInDb.isPresent()){
            this.clientDao.delete(personInDb.get());
        }else{
            throw new ResourceNotFoundException("Client id : " + clientId + " not found");
        }
    }

}
