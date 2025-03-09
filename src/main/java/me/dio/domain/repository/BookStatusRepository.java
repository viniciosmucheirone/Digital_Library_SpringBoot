package me.dio.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import me.dio.domain.model.BookStatus.Status;
import me.dio.domain.model.BookStatus;

public interface BookStatusRepository extends JpaRepository<BookStatus, Long > {
	 // Método para buscar BookStatus por Status
    List<BookStatus> findByStatus(Status status);
}
