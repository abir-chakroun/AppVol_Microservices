package API;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Repository.ClientRepository;
import models.Client;

@RequestMapping(path = "Service-Client")
@RestController
public class ClientController {
	
	ClientRepository repository;
	
	@GetMapping("/Clients")
	public List<Client> getAllClients() {
		System.out.println("Get all Clients");
	    return (List<Client>) (repository.findAll());
	    }
	 
	  @PostMapping(value = "/Clients/create")
	  public Client postClient (@Valid @RequestBody Client Client) {
		  System.out.println("new Client");
		  Client _Instrument = repository.save(Client);
		  return _Instrument;
	  }
	  
	  @DeleteMapping("/Clients/{num}")
	  public ResponseEntity<String> deleteClient(@PathVariable("num") Long num) {
		System.out.println("Delete Client with Code = " + num );
	    repository.delete(num);
	    return new ResponseEntity<String>("Client has been deleted!", HttpStatus.OK);
	  }
	  
	  @DeleteMapping("/Clients/delete")
	  public ResponseEntity<String> deleteAllClients() {
	    System.out.println("Delete All Clients");
	    repository.deleteAll();
	    return new ResponseEntity<String>("All Clients have been deleted!", HttpStatus.OK);
	  }
	  
	  @PutMapping("/Clients/{num}")
	  public ResponseEntity<Client> updateClient(@PathVariable("num") Long num, @RequestBody Client Client) {
	 
		System.out.println("Update Client");
		
		Client Data = repository.findOne(num);
	    if (Data!= null ) {
	    
	    Client c = Data;
	      c.setFullName(Client.getFullName());
	      c.setEmail(Client.getEmail());
	      c.setAdress(Client.getAdress());
	      c.setTel(Client.getTel());
	      c.setGender(Client.getGender());
	      return new ResponseEntity<Client>(repository.save(c), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
}
