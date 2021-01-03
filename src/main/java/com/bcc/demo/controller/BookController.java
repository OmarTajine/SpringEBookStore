package com.bcc.demo.controller;

import com.bcc.demo.dao.entity.Book;
import com.bcc.demo.dto.BookDto;
import com.bcc.demo.dto.BookDtoAdd;
import com.bcc.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	IBookService bookService;

	@GetMapping("/")
	public List<Book> getBooks() {
		return bookService.getAllbooks();
	}

	@GetMapping("/find")
	public Book getBook(@RequestParam Long id) {
		return bookService.findById(id);
	}

	@PostMapping("/add")
	public Book addBook(@RequestBody Book book) {
		return bookService.add(book);
	}

	@DeleteMapping("/remove")
	public boolean deleteBook(@RequestParam Long id) {
		return bookService.deleteById(id);
	}

	@PutMapping("/update")
	public boolean updateBook(@RequestBody Book book) {
		return bookService.update(book);
	}

	@GetMapping("/all")
	public List<BookDto> getAll() {
		return bookService.getAll();
	}

	@PostMapping("/add_dto")
	public BookDto addBookDto(@RequestBody BookDtoAdd bookDtoAdd) {
		return bookService.add(bookDtoAdd);
	}
	
	@GetMapping("/allprices")
	public double calculatePrice(@RequestBody Book book) {
		return bookService.calculatePrice();
	}
}
