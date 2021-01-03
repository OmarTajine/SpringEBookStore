package com.bcc.demo.dao;

import com.bcc.demo.dao.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookDao {

    List<Book>getAllBooks();

    Book addBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(Long id);

    boolean deleteBook(Book Book);
    
    double calculatePrice();

    Optional<Book> findById(Long id);

}
