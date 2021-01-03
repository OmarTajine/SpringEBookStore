package com.bcc.demo.service;

import com.bcc.demo.dao.entity.Book;
import com.bcc.demo.dto.BookDto;
import com.bcc.demo.dto.BookDtoAdd;

import java.util.List;

public interface IBookService {
    List<Book> getAllbooks();

    Book add(Book book);

    boolean update(Book book);

    boolean deleteById(Long id);

    boolean deleteByBook(Book book);

    Book findById(Long id);

    List<BookDto> getAll();

    BookDto add(BookDtoAdd bookDtoAdd);
    
    double calculatePrice();
}
