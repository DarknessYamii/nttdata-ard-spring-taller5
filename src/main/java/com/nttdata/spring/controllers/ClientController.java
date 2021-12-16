package com.nttdata.spring.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nttdata.spring.persistence.Client;
import com.nttdata.spring.services.ClientManagementServiceI;
/**
 * Controller of Client + Web
 * @author DarknessYamii
 *
 */
@Controller
public class ClientController {

	@Autowired
	ClientManagementServiceI clientService;
		/**
		 * Show every Client or Only the clients with X name
		 * @param model
		 * @param name
		 * @return
		 */
	@GetMapping(path = { "/index", "/searchClient" })
	public String showClientList(Model model, String name) {
		if (name != null && !name.isBlank()) {

			model.addAttribute("clients", clientService.searchByName(name));
		} else {
			model.addAttribute("clients", clientService.searchAll());
		}
		return "index";
	}

	@GetMapping("/add")
	public String showAddForm(Client newClient) {
		return "addClient";
	}
	/**
	 * addClient using clientService
	 * @param newClient
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/addClient")
	public String addClient(@Valid Client newClient, BindingResult result, Model model) {
		if (result.hasErrors()) {	
		return "addClient";
		}
		clientService.insertNewClient(newClient);
		return "redirect:/index";
	}
	/**
	 * Edit client 
	 * @param idClient
	 * @param model
	 * @return
	 */
	@GetMapping("/edit/{idClient}")
	public String showUpdateForm(@PathVariable("idClient") long idClient, Model model) {
		Client updatedClient = clientService.searchById(idClient);
		model.addAttribute("client", updatedClient);
		return "updateClient";
	}

	@PostMapping("/update/{idClient}")
	public String updateClient(@PathVariable("idClient") long idClient, @Valid Client updatedClient, BindingResult result, Model model) {
		if (result.hasErrors()) {
			updatedClient.setIdClient(idClient);
			return "updateClient";
		}

		clientService.updateClient(updatedClient);
		return "redirect:/index";
	}
	/**´
	 * Delete client
	 * @param idClient
	 * @param model
	 * @return
	 */
	@GetMapping("/delete/{idClient}")
	public String deleteClient(@PathVariable("idClient") long idClient, Model model) {
		Client deletedClient = clientService.searchById(idClient);
		clientService.deleteClient(deletedClient);
		return "redirect:/index";
	}
}
