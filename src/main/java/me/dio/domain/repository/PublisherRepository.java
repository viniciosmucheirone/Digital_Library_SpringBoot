package me.dio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.domain.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long > {
}
