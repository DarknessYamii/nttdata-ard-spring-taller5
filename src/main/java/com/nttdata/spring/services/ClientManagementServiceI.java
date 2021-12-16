package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.persistence.Client;
/**
 * Clase Servicio que controla instancias de Client
 * @author DarknessYamii
 *
 */
public interface ClientManagementServiceI {
	/**
	 * Insertar nuevo client
	 * @param newClient
	 */
	public void insertNewClient(final Client newClient);
	/**
	 * Update client
	 * @param updatedClient
	 */
	public void updateClient(final Client updatedClient);
	/**
	 * Delete client
	 * @param deletedClient
	 */
	public void deleteClient(final Client deletedClient);
/**
 * Search by Id a Client
 * @param idClient
 * @return
 */
	public Client searchById(final Long idClient);
	/**
	 * Get every row of Client
	 * @return
	 */
	public List<Client> searchAll();
	/**
	 * Search Client by Name
	 * @param name
	 * @return
	 */
	public List<Client> searchByName(final String name);
	/**
	 * Search Client by FULL NAME
	 * @param name
	 * @param firstName
	 * @param secondName
	 * @return
	 */
	public List<Client> searchByFullName(String name, String firstName, String secondName);

}
