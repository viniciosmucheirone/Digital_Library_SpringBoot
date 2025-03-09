package me.dio.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import me.dio.domain.model.Person;
import me.dio.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.create(person);
        return ResponseEntity.status(201).body(createdPerson);
    }

    @GetMapping("email/{email}")
    public ResponseEntity<Person> getPersonByEmail(@PathVariable String email) {
        return personService.findPersonByEmail(email)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // Obter editora por ID
    @GetMapping("id/{id}")
    public ResponseEntity<Person> getPublisher(@PathVariable Long id) {
    	Person person = personService.getPerson(id);
        return ResponseEntity.ok(person);
    }
    
    
    // Atualizar um Person
    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person person) {
    	Person updatePerson = personService.updatePerson(id, person);
        return ResponseEntity.ok(updatePerson); // Retorna o Person atualizado
    }
    
    // Deletar um livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
    	personService.deletePerson(id);
        return ResponseEntity.noContent().build(); // Retorna HTTP 204 No Content, sem corpo
    }
}





