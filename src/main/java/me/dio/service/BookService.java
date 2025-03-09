package me.dio.service;

import java.util.List;

import me.dio.domain.model.Book;

public interface BookService {
	Book createBook(Book book);
	
	List<Book> getAllBooks();
	
	Book getBook(Long id);
	
	Book updateBook(Long id, Book book);

	void deleteBook(Long id);
}
