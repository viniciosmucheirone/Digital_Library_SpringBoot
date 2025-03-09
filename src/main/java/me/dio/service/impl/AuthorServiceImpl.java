package me.dio.service.impl;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.domain.model.Author;
import me.dio.domain.repository.AuthorRepository;
import me.dio.service.AuthorService;

@Service 
public class AuthorServiceImpl implements AuthorService {
	
	
	   @Autowired
	   private AuthorRepository authorRepository;

	   @Override
	   public List<Author> getAuthorsByIds(List<Long> ids) {
	        return authorRepository.findAllById(ids);  // Usa o método para buscar os autores por uma lista de IDs
	   }

	   @Override
	   public Author createAuthor(Author author) {
	        return authorRepository.save(author);
	    }

	   
       
	   @Override
	   public Author updateAuthor(Long id, Author authorDetails) {
	       // Verificar se o autor existe
	       Author existingAuthor = authorRepository.findById(id).orElseThrow(NoSuchElementException::new);

	       // Atualizando os detalhes do autor
	       existingAuthor.setName(authorDetails.getName()); // Atualizando o nome (ou outros atributos)

	       // Salvar e retornar o autor atualizado
	       return authorRepository.save(existingAuthor);
	   }

	@Override
	public Author getAuthor(Long id) {
		return authorRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}
	
    @Override
    public void deleteAuthor(Long id) {
        // Verificar se o livro existe
        Author existingAuthor = authorRepository.findById(id).orElseThrow(NoSuchElementException::new);

        // Deletar o livro
        authorRepository.delete(existingAuthor);
    }

}
