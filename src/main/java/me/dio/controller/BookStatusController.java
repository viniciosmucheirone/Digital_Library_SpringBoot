package me.dio.controller;
import me.dio.domain.model.BookStatus.Status;
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
import me.dio.domain.model.BookStatus;
import me.dio.service.BookStatusService;

@RestController
@RequestMapping("/api/bookstatus")
public class BookStatusController {

    @Autowired
    private BookStatusService bookStatusService;

    // Criar status de um livro
    @PostMapping
    public ResponseEntity<BookStatus> createBookStatus(@RequestBody BookStatus bookStatus) {
        BookStatus createdBookStatus = bookStatusService.createBookStatus(bookStatus);
        return ResponseEntity.status(201).body(createdBookStatus);
    }

    // Obter status de livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<BookStatus> getBookStatus(@PathVariable Long id) {
        BookStatus bookStatus = bookStatusService.getBookStatus(id);
        return ResponseEntity.ok(bookStatus);
    }
    
    // Obter todos os livros
    @GetMapping
    public ResponseEntity<List<BookStatus>> getAllBookStatus() {
        List<BookStatus> bookStaus = bookStatusService.getAllBookStatus();
        return ResponseEntity.ok(bookStaus);
    }
    
    
    // Endpoint para listar BookStatus por Status
    @GetMapping("/status/{status}")
    public List<BookStatus> findByStatus(@PathVariable Status status) {
        return bookStatusService.findByStatus(status); // Chamando o serviço
    }
    
    // Atualizar um livro
    @PutMapping("/{id}")
    public ResponseEntity<BookStatus> updateBookStatus(@PathVariable Long id, @RequestBody BookStatus bookStatus) {
        BookStatus updatedBookStatus = bookStatusService.updateBookStatus(id, bookStatus);
        return ResponseEntity.ok(updatedBookStatus); // Retorna o livro atualizado
    }

    // Deletar um livro
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookStatus(@PathVariable Long id) {
        bookStatusService.deleteBookStatus(id);
        return ResponseEntity.noContent().build(); // Retorna HTTP 204 No Content, sem corpo
    }

}





