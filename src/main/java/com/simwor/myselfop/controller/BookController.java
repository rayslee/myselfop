package com.simwor.myselfop.controller;

import com.simwor.myselfop.integration.volksbook.BookIntegration;
import com.simwor.volksbook.bean.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookIntegration bookIntegration;

    @GetMapping("/query-by-isbn")
    public Book queryByIsbn(@RequestParam("isbn") String isbn) {
        return bookIntegration.queryByIsbn(isbn);
    }

}
