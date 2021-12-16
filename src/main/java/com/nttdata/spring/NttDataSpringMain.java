package com.nttdata.spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.persistence.Client;
import com.nttdata.spring.services.ClientManagementServiceI;
/**
 * Main Spring MVC API
 * @author DarknessYamii
 *
 */
@SpringBootApplication
public class NttDataSpringMain implements CommandLineRunner {

	@Autowired
	ClientManagementServiceI serviceClient;
	
	public static void main(String[] args) {
		SpringApplication.run(NttDataSpringMain.class, args);
	}

	/* GENERATE A TEST CLIENT*/
	@Override
	public void run(String... args) throws Exception {
	Client cliente1 = new Client();
	cliente1.setIdClient(1L);
	cliente1.setName("Maria del Carmen");
	cliente1.setFirstName("Gonzalez");
	cliente1.setSecondName("Carranza");
	cliente1.setDni("15456782T");
	cliente1.setBirthdate(new Date(2002,06,01));
	
	serviceClient.insertNewClient(cliente1);
	serviceClient.updateClient(cliente1);

	}

}
