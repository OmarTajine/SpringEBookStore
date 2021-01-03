package com.bcc.demo.controller;

import com.bcc.demo.dao.entity.Book;
import com.bcc.demo.service.IBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
	@MockBean
    private IBookService bookService;

    @Test
    void getBooks() throws Exception {

        List<Book> bookList = Arrays.asList(
                new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010"),
                new Book(2L,"The Hobbit","Robert Greene",40.00,"10/10/2010")
        );

        when(bookService.getAllbooks()).thenReturn(bookList);

        mockMvc.perform(get("/book/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].id", is(101)))
                .andExpect(jsonPath("$.[1].id", is(102)))
                .andExpect(jsonPath("$.[0].title", is("The Laws Of Human Nature")))
                .andExpect(jsonPath("$.[1].title", is("The Hobbit")))
                .andExpect(jsonPath("$.[0].author", is("Robert Greene")))
                .andExpect(jsonPath("$.[1].author", is("John Ronald Reuel Tolkien")))
                .andExpect(jsonPath("$.[0].price", is(30)))
                .andExpect(jsonPath("$.[1].price", is(40)))
                .andExpect(jsonPath("$.[0].releaseDate", is("10-10-2010")))
                .andExpect(jsonPath("$.[1].releaseDate", is("10-10-2010")))
        ;

    }

    @Test
    void getBook() throws Exception {
        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"31-03-2015");

        when(bookService.findById(any(Long.class))).thenReturn(book);

        mockMvc.perform(get("/book/find").param("id", "0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(101)))
                .andExpect(jsonPath("$.[0].title", is("The Laws Of Human Nature")))
                .andExpect(jsonPath("$.[0].price", is(30)))
                .andExpect(jsonPath("$.[0].releaseDate", is(10-10-2010)))
        ;
    }

    @Test
    void addBook() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");
        Book savedBook = new Book(2L,"The Hobbit","Robert Greene",40.00,"10/10/2010");

        when(bookService.add(any(Book.class))).thenReturn(savedBook);

        mockMvc.perform(post("/book/add").content(mapper.writeValueAsString(book))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(101)))
                .andExpect(jsonPath("$.[0].title", is("The Laws Of Human Nature")))
                .andExpect(jsonPath("$.[0].price", is(30)))
                .andExpect(jsonPath("$.[0].releaseDate", is(10-10-2010)))
        ;
    }

    @Test
    void deleteBook() throws Exception {

        when(bookService.deleteById(any(Long.class))).thenReturn(true);

        mockMvc.perform(delete("/book/remove").param("id", "0"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", is(true)))
        ;
    }

}