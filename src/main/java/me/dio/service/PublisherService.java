package me.dio.service;


import me.dio.domain.model.Publisher;

public interface PublisherService {
  Publisher createPublisher(Publisher publisher);
  Publisher getPublisherById(Long id);
    
  Publisher updatePublisher(Long id, Publisher publisher);
  
  void deletePublisher(Long id);
}
