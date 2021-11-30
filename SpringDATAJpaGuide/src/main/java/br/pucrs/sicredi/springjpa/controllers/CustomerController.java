package br.pucrs.sicredi.springjpa.controllers;

import br.pucrs.sicredi.springjpa.repo.CustomerRepository;
import br.pucrs.sicredi.springjpa.controllers.CustomerDTO;
import br.pucrs.sicredi.springjpa.entity.Customer;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")   // Ou poderiamos por o "/dogs" em cada anotação
public class CustomerController {
	@Autowired 
	private final CustomerRepository repo;


	@PostMapping
	public void postCust(@RequestBody CustomerDTO dto) {
		repo.save(new Customer(dto.getFirstName(), dto.getLastName()));
	}

	@GetMapping
	public List<Customer> getCusts() {
		List<Customer> res = new ArrayList<>();

		for (Customer customer : repo.findAll()) {
			res.add(customer);
		}
		
		return res;
	}
		@GetMapping("/{id}")
		public Customer getById(@PathVariable(required = true) long id) {
			return repo.findById(id);
		}
	
		@DeleteMapping("/{id}")
		public void delete(@PathVariable(required = true) long id) {
			repo.deleteById(id);
		}
}