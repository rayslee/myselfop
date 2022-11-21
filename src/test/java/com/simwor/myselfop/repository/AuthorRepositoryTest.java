package com.simwor.myselfop.repository;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthorRepositoryTest {



//    @Autowired
//    private AuthorRepository authorRepository;
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Test
//    public void testSave() {
//        Author author = new Author();
//        author.setName("杨本芬");
//        authorRepository.save(author);
//
//        Book book = new Book();
//        book.setIsbn("1234567890");
//        book.setName("秋园");
//        book.setAuthors(Collections.singletonList(author));
//        bookRepository.save(book);
//    }
//
//    @Test
//    @Transactional
//    public void testFind() {
//        Author author = authorRepository.findById(2l).get();
//        Book book = author.getBooks().get(0);
//
//        assertEquals("Author(id=2, name=杨本芬)", author.toString());
//        assertEquals("Book(id=3, isbn=1234567890, name=秋园, authors=[Author(id=2, name=杨本芬)])", book.toString());
//    }

}
