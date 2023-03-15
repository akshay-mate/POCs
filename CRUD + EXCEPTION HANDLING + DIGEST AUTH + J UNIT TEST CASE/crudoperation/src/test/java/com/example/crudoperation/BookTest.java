package com.example.crudoperation;

import com.example.crudoperation.model.Books;
import com.example.crudoperation.repository.BooksRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;




@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookTest {

    @Autowired
    private BooksRepository booksRepository;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void testAddBook()
    {
        Books books = new Books();
        books.setBookid(1122);
        books.setBookname("The Nile");
        books.setAuthor("Toby Wilkinson");
        books.setPrice(878);
        booksRepository.save(books);
        //Assertions.
                assertThat(books.getBookid()).isGreaterThan(0);
    }


    @Test
    @Order(2)
    @Rollback(value = false)
    public void testBookById()
    {
        Books books = booksRepository.getById(1122);
        //Assertions.
                assertThat(books.getBookid()).isEqualTo(1122);
    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void testGetListAllBooks()
    {
        List<Books> booksList = booksRepository.findAll();
       // Assertions.
                assertThat(booksList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void testDeleteBook() throws NoSuchElementException
    {
        int id=1122;
        boolean before = booksRepository.findById(id).isPresent();
        booksRepository.deleteById(id);
        boolean after = booksRepository.findById(id).isPresent();
        Assertions.assertTrue(before);
        Assertions.assertFalse(after);


    }

/*    @Test
    @Order(5)
    @Rollback(value = false)
    public void testUpdateBook(){

        Books books = booksRepository.getById(1122);

        books.setPrice(666);

        booksRepository.save(books);

        Books updatedBook = booksRepository.getById(1122);


        assertThat(updatedBook.getPrice()).isEqualTo(666);
*/
    }


