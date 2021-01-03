package com.bcc.demo.dao.impl;

import com.bcc.demo.dao.IBookDao;
import com.bcc.demo.dao.entity.Book;
import com.bcc.demo.dao.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/books")
@Repository
public class BookDaoImpl implements IBookDao {

    @Autowired
     BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public boolean deleteBook(Long id) {
        if(bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean updateBook(Book book) {
        if(bookRepository.save(book)!=null)
        return true;
        else
            return false;
    }



    @Override
    public boolean deleteBook(Book book) {

        return false;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

	@Override
	public double calculatePrice() {
		return calculatePrice();
	}
}
