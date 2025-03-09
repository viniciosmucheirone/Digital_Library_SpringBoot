package me.dio.service.impl;


import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.domain.model.Publisher;

import me.dio.domain.repository.PublisherRepository;
import me.dio.service.PublisherService;

@Service 
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }
    
    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
	@Override
	public Publisher updatePublisher(Long id, Publisher publisherDetails) {
		Publisher existingPublisher = publisherRepository.findById(id).orElseThrow(NoSuchElementException::new);

	if (existingPublisher == null) {
	    throw new RuntimeException("Publisher não encontrado");
	}
	existingPublisher.setName(publisherDetails.getName()); 
	existingPublisher.setAddress(publisherDetails.getAddress()); 

	return publisherRepository.save(existingPublisher);
	}
	
	
    @Override
    public void deletePublisher(Long id) {
        // Verificar se o livro existe
        Publisher existingPublisher = publisherRepository.findById(id).orElseThrow(NoSuchElementException::new);

        // Deletar o livro
        publisherRepository.delete(existingPublisher);
    }

   
    
    
}
