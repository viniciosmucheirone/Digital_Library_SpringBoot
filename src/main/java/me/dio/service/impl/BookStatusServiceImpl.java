package me.dio.service.impl;

import me.dio.domain.model.BookStatus.Status;
import me.dio.domain.model.Person;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.dio.domain.model.Book;
import me.dio.domain.model.BookStatus;
import me.dio.domain.repository.BookStatusRepository;
import me.dio.service.BookService;
import me.dio.service.BookStatusService;
import me.dio.service.PersonService;


@Service 
public class BookStatusServiceImpl implements BookStatusService {

	
    @Autowired
    private BookStatusRepository bookStatusRepository;

    @Autowired
    private PersonService personService;  // Para acessar o serviço Publisher
    
    @Autowired
    private BookService bookService;
    
    @Override
    public BookStatus createBookStatus(BookStatus bookStatus) {
        return bookStatusRepository.save(bookStatus);
    }

    @Override
    public BookStatus getBookStatus(Long id) {
        return bookStatusRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
    @Autowired
    public BookStatusServiceImpl(BookStatusRepository bookStatusRepository) {
        this.bookStatusRepository = bookStatusRepository;
    }

    @Override
    public List<BookStatus> findByStatus(Status status) {
        return bookStatusRepository.findByStatus(status); // Chamando o repositório
    }

	@Override
	public List<BookStatus> getAllBookStatus() {
		return bookStatusRepository.findAll();
	}

    @Override
    public void deleteBookStatus(Long id) {
        // Verificar se o livro existe
        BookStatus existingBookStatus = bookStatusRepository.findById(id).orElseThrow(NoSuchElementException::new);

        if (existingBookStatus == null) {
            throw new RuntimeException("Author não encontrado");
        }

        // Deletar o livro
        bookStatusRepository.delete(existingBookStatus );
    }

    @Override
    public BookStatus updateBookStatus(Long id, BookStatus bookStatus) {
        BookStatus existingBookStatus = bookStatusRepository.findById(id).orElseThrow(NoSuchElementException::new);

        if (existingBookStatus == null) {
            throw new RuntimeException("BookStatus não encontrado");
        }
        
      existingBookStatus.setStatus(bookStatus.getStatus());
	  existingBookStatus.setRegistrationDate(bookStatus.getRegistrationDate());
	  existingBookStatus.setRating(bookStatus.getRating());
	  existingBookStatus.setComment(bookStatus.getComment());
	  existingBookStatus.setPriority(bookStatus.getPriority());
	  existingBookStatus.setReason(bookStatus.getReason());

	  Person person = personService.getPerson(bookStatus.getPerson().getId());
	  existingBookStatus.setPerson(person);
      
	
      Book book = bookService.getBook(bookStatus.getBook().getId());
      existingBookStatus.setBook(book);

     
      return bookStatusRepository.save(existingBookStatus);


    }
    
    
}
