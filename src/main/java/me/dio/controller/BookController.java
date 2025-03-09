package me.dio.controller;
import java.util.List;
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
import me.dio.domain.model.Book;
import me.dio.service.BookService;


@RestController
@RequestMapping("/api/book")
public class BookController {

	 @Autowired
	    private BookService bookService;

	    // Criar um novo livro
	    @PostMapping
	    public ResponseEntity<Book> createBook(@RequestBody Book book) {
	        try {
	            Book createdBook = bookService.createBook(book);
	            return ResponseEntity.status(201).body(createdBook);
	        } catch (RuntimeException ex) {
	            return ResponseEntity.badRequest().body(null);  // Você pode personalizar a resposta aqui
	        }
	    }

	    // Obter todos os livros
	    @GetMapping
	    public ResponseEntity<List<Book>> getAllBooks() {
	        List<Book> books = bookService.getAllBooks();
	        return ResponseEntity.ok(books);
	    }
	    
	    // Obter livro por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Book> getBook(@PathVariable Long id) {
	        Book book = bookService.getBook(id);
	        return ResponseEntity.ok(book); // Retorna o livro em formato JSON
	    }

	    // Atualizar um livro
	    @PutMapping("/{id}")
	    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
	        Book updatedBook = bookService.updateBook(id, book);
	        return ResponseEntity.ok(updatedBook); // Retorna o livro atualizado
	    }

	    // Deletar um livro
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
	        bookService.deleteBook(id);
	        return ResponseEntity.noContent().build(); // Retorna HTTP 204 No Content, sem corpo
	    }
}





