package me.dio.service;

import java.util.Optional;


import me.dio.domain.model.Person;

public interface PersonService {
	Optional<Person> findPersonByEmail(String email);
	
	Person create(Person person);
	
	Person getPerson(Long id);
	
	Person updatePerson(Long id, Person person);

	void deletePerson(Long id);

}
