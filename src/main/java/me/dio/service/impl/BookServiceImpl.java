package me.dio.service.impl;

import me.dio.domain.model.Book;
import me.dio.domain.model.Author;
import me.dio.domain.model.Publisher;
import me.dio.domain.repository.BookRepository;
import me.dio.service.AuthorService;
import me.dio.service.PublisherService;
import me.dio.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service 
public class BookServiceImpl implements BookService {

	@Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;  // Para acessar o serviço Author

    @Autowired
    private PublisherService publisherService;  // Para acessar o serviço Publisher

    @Override
    public Book createBook(Book book) {
        // Verificar se os autores existem
        List<Author> authors = book.getAuthors();
        for (Author author : authors) {
            Optional<Author> existingAuthor = Optional.ofNullable(authorService.getAuthor(author.getId()));
            if (!existingAuthor.isPresent()) {
                throw new RuntimeException("Author with id " + author.getId() + " not found");
            }
        }

        // Verificar se o publisher existe
        Publisher publisher = book.getPublisher();
        Optional<Publisher> existingPublisher = Optional.ofNullable(publisherService.getPublisherById(publisher.getId()));
        if (!existingPublisher.isPresent()) {
            throw new RuntimeException("Publisher with id " + publisher.getId() + " not found");
        }

        // Salvar o livro
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        // Verificar se o livro existe
        Book existingBook = bookRepository.findById(id).orElseThrow(NoSuchElementException::new);


        // Atualizar as informações do livro com os dados recebidos
        existingBook.setTitle(book.getTitle());
        existingBook.setDescription(book.getDescription());

        // Atualizar a lista de autores
        List<Long> authorIds = book.getAuthors().stream().map(Author::getId).toList();
        List<Author> authors = authorService.getAuthorsByIds(authorIds);
        existingBook.setAuthors(authors);

        // Atualizar o publisher
        Publisher publisher = publisherService.getPublisherById(book.getPublisher().getId());
        existingBook.setPublisher(publisher);

        // Salvar e retornar o livro atualizado
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        // Verificar se o livro existe
        Book existingBook = bookRepository.findById(id).orElseThrow(NoSuchElementException::new);

        // Deletar o livro
        bookRepository.delete(existingBook);
    }

    
    

}
