package com.nttdata.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nttdata.spring.persistence.Client;
import com.nttdata.spring.persistence.ClientRepository;
/**
 * Implementacion de ClientManagementI
 * @author DarknessYamii
 *
 */
@Service
public class ClientManagementServiceImpl implements ClientManagementServiceI {

	/* Repository which consume the service */
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public void insertNewClient(Client newClient) {
		if (newClient != null && newClient.getIdClient() == null) {

			clientRepository.saveAndFlush(newClient);

		}
	}

	@Override
	public void updateClient(Client updatedClient) {
		if (updatedClient != null && updatedClient.getIdClient() != null) {

			clientRepository.saveAndFlush(updatedClient);

		}

	}

	@Override
	public void deleteClient(Client deletedClient) {
		if (deletedClient != null && deletedClient.getIdClient() != null) {

			clientRepository.delete(deletedClient);
		}

	}

	@Override
	@Transactional
	public Client searchById(Long idClient) {

		return clientRepository.findByIdClient(idClient);
	}

	@Override
	public List<Client> searchAll() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public List<Client> searchByName(String name) {
		
		return clientRepository.findByName(name);
	}

	@Override
	public List<Client> searchByFullName(String name, String firstName, String secondName) {
		// TODO Auto-generated method stub
		return clientRepository.findByNameAndFirstNameAndSecondName(name, firstName, secondName);
	}

}
