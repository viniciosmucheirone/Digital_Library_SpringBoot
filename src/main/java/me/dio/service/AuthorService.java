package me.dio.service;

import java.util.List;

import me.dio.domain.model.Author;

public interface AuthorService {
	Author createAuthor(Author author);
	Author getAuthor(Long id);
	
	List<Author> getAuthorsByIds(List<Long> ids);
	
	Author updateAuthor(Long id, Author author);
	
	void deleteAuthor(Long id);
}
