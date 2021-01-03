package com.bcc.demo.dao.repository;

import com.bcc.demo.dao.entity.Book;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Before
    public void setUp() {
        // set default data to use in all test methods
        Book book = new Book(1L,"The Laws Of Human Nature","Robert Greene",30.00,"10/10/2010");
        testEntityManager.merge(book);
    }

    @Test
    public void findById() {
        Optional<Book> bookEntity = bookRepository.findById(1L);
        //assertThat(bookEntity.getTitle()).isEqualTo("The Laws Of Human Nature");
    }
}