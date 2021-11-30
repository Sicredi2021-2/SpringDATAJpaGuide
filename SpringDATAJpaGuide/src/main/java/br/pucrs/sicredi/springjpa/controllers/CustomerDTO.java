package br.pucrs.sicredi.springjpa.controllers;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CustomerDTO {
	private String firstName;
	private String lastName;

	protected CustomerDTO() {}

	public CustomerDTO(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format(
				"CustomerDTO[firstName='%s', lastName='%s']",
				firstName, lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
