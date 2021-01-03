package com.bcc.demo.dao.repository;

import com.bcc.demo.dao.entity.Book;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findById(Long id);
}
