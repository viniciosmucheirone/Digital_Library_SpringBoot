package me.dio.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.domain.model.Person;
import me.dio.domain.repository.PersonRepository;
import me.dio.service.PersonService;


@Service 
public class PersonServiceImpl implements PersonService {

	
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person create(Person person) {
    	if (personRepository.existsByEmail(person.getEmail())) {
            throw new IllegalArgumentException("This Email already exists.");
        }
    	
        return personRepository.save(person);    
    }

    @Override
    public Optional<Person> findPersonByEmail(String email) {
        return personRepository.findByEmail(email);
    }
    
    @Override
    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

	@Override
	public Person updatePerson(Long id, Person personDetails) {
	// Verificar se o autor existe
	Person existingPerson = personRepository.findById(id).orElseThrow(NoSuchElementException::new);

	// Se o autor não for encontrado, lança exceção
	if (existingPerson == null) {
	    throw new RuntimeException("Perssoa não encontrada");
	}

	// Atualizando os detalhes do autor
    // Atualizando os detalhes da pessoa
    existingPerson.setName(personDetails.getName()); // Atualizando o nome
    existingPerson.setEmail(personDetails.getEmail()); // Atualizando o email
    existingPerson.setPassword(personDetails.getPassword()); // Atualizando a senha (se necessário)


	// Salvar e retornar o autor atualizado
	return personRepository.save(existingPerson);
	}
   
    @Override
    public void deletePerson(Long id) {

        Person existingPerson = personRepository.findById(id).orElseThrow(NoSuchElementException::new);

        personRepository.delete(existingPerson);
    }

	

}
