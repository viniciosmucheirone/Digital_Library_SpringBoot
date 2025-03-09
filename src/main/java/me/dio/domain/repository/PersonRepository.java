package me.dio.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.domain.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
    
    boolean existsByEmail(String accountNumber);
}