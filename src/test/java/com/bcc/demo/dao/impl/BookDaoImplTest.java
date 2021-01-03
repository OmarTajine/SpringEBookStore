package com.bcc.demo.dao.impl;

import com.bcc.demo.dao.entity.Book;
import com.bcc.demo.dao.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class BookDaoImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookDaoImpl bookDao;

    @Test
    public void getAllbooks() {
        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");
        Mockito.when((bookRepository.findAll())).thenReturn(Arrays.asList(book));
        assertEquals(book, bookDao.getAllBooks().get(0));
    }

    @Test
    public void addBook() {

        //book to saved : with id = null
        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");

        //book saved with auto generated id
        Book savedBook = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");

        Mockito.when((bookRepository.save(any(Book.class)))).thenReturn(savedBook);

        assertEquals(savedBook, bookDao.addBook(book));
    }

    @Test
    public void updateBook() {

        Book bookToUpdate = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");

        Book updatedBook = new Book(1L,"The Hobbit","Robert Greene",40.00,"10/10/2010");

        Mockito.when((bookRepository.save(any(Book.class)))).thenReturn(bookToUpdate);

        assertEquals(bookToUpdate, bookDao.addBook(updatedBook));
    }

    @Test
    public void deleteBook() {

        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");

        /**
         *  method deleteBook use id as param to delete book by id : in this method we use existById
         *  to check if the id exist in the database , if true we call delete book by id
         */

        Mockito.when(bookRepository.existsById(any(Long.class))).thenReturn(true);

        bookDao.deleteBook(book.getId());

        Mockito.verify(bookRepository).deleteById(book.getId());

//        assertEquals(bookToUpdate,bookDao.addBook(updatedBook));
    }

    @Test
    public void deleteBook1() {
    }

    @Test
    public void findById() {
        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");

        Mockito.when((bookRepository.findById(any(Long.class)))).thenReturn(Optional.of(book));

        assertEquals(book, bookDao.findById(book.getId()).get());
    }
}