package com.pkslow.cloud.rest;

import com.pkslow.cloud.rest.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @GetMapping("/all")
    public List<Book> books() {
        Book book = Book.builder()
                .id(0)
                .title("Harry Potter")
                .build();

        return Collections.singletonList(book);
    }
}
