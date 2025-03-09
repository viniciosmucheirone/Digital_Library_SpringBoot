package me.dio.service;
import me.dio.domain.model.BookStatus.Status;
import java.util.List;

import me.dio.domain.model.BookStatus;

public interface BookStatusService {
	  BookStatus createBookStatus(BookStatus bookStatus);
	  BookStatus getBookStatus(Long id);
	  List<BookStatus> getAllBookStatus();
	  
	  List<BookStatus> findByStatus(Status status);
	
	
	  void deleteBookStatus(Long id);
	  
	  BookStatus updateBookStatus(Long id, BookStatus bookStatus);
	  
}
