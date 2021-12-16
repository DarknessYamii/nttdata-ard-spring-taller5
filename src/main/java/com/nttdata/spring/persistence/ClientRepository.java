package com.nttdata.spring.persistence;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Reposotiry of Client
 * Create every method we need
 * @author DarknessYamii
 *
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	/**
	 * Search the Client by ID
	 * @param idClient
	 * @return Client
	 */
	public Client findByIdClient(Long idClient);
	/**
	 * 
	 * Search the Client by Name
	 * @param name
	 * @return List<Client>
	 */
	public List<Client> findByName(String name);
	/**
	 * Search the Client by FullName
	 * @param name
	 * @param firstName
	 * @param secondName
	 * @return List<Client>
	 */
	public List<Client> findByNameAndFirstNameAndSecondName(String name, String firstName, String secondName);
	
}
