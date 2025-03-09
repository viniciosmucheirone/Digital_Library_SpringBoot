package me.dio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.domain.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long > {
	
	  List<Author> findAllById(Iterable<Long> ids);
}
