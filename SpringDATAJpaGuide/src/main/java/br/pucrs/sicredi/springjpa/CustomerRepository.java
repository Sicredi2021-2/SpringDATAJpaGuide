package br.pucrs.sicredi.springjpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.pucrs.sicredi.springjpa.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByLastName(String lastName);

  Customer findById(long id);
}