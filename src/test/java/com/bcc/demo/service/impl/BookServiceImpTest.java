package com.bcc.demo.service.impl;

import com.bcc.demo.dao.IBookDao;
import com.bcc.demo.dao.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookServiceImpTest {

    @Mock
    private IBookDao bookDao;

    @InjectMocks
    private BookServiceImp bookService;

    @Test
    public void getAllbooks() {

        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");

        Mockito.when(bookDao.getAllBooks()).thenReturn(Arrays.asList(book));

        Assert.assertEquals(1, bookService.getAllbooks().size());
    }

    @Test
    public void add() {

    }

    @Test
    public void update() {
    }

    @Test
    public void deleteById() {
        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");

        Mockito.when(bookDao.deleteBook(any(Long.class))).thenReturn(true);
        Assert.assertTrue(bookService.deleteById(book.getId()));
    }

    @Test
    public void deleteByBook() {
    }

    @Test
    public void findById() {
        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");

        Mockito.when(bookDao.findById(any(Long.class))).thenReturn(Optional.of(book));
        Assert.assertEquals(book, bookService.findById(book.getId()));
    }
}