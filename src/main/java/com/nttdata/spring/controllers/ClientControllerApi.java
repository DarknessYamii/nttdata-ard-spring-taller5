package com.nttdata.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.persistence.Client;
import com.nttdata.spring.services.ClientManagementServiceI;
/**
 * API Controller
 * @author DarknessYamii
 *
 */
@RestController
@RequestMapping("/api")
public class ClientControllerApi {

	@Autowired
	private ClientManagementServiceI clientService;
	
	/**
	 * @test GET: localhost:8080/api/clients
	 * Get every Client on the BBDD
	 * @return List<Client>
	 */
	@GetMapping("/clients")
	public List<Client> findAll(){
		return clientService.searchAll();
	}
	/**
	 * @test GET: localhost:8080/api/clients/find/1
	 * Get the Client the X ID
	 * @param idClient
	 * @return
	 */
	@GetMapping("/clients/find/{idClient}")
	public Client getClient(@PathVariable Long idClient) {
		Client client = clientService.searchById(idClient);
		if(client == null ) {
			throw new RuntimeException("clientId not found "+ idClient);
		}
		return client;
	}
	/**
	 * @test POST: localhost:8080/api/add   BODY -> RAW -> JSON
	 * Add a new client
	 * @param client
	 */
	@PostMapping("/add")
	public void addClient(@RequestBody Client client) {
		clientService.insertNewClient(client);
	}
	/**
	 * @test DELETE: localhost:8080/api/delete/1
	 * Delete a clien with ID
	 * @param idClient
	 */
	@DeleteMapping("/delete/{idClient}")
	public void deleteClient(@PathVariable Long idClient) {
		Client client = clientService.searchById(idClient);
		if (client != null)
			clientService.deleteClient(client);
	}
	
}
