package org.example.controller;

import java.util.List;
import org.example.data.BookDto;
import org.example.ports.api.BookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookServicePort bookServicePort;

    @GetMapping
    public List<BookDto> getAllBook(){
        return bookServicePort.getAllBook();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) throws Exception {
        return bookServicePort.getBookById(id);
    }

    @PostMapping()
    public BookDto addBook(@RequestBody BookDto bookDto) throws Exception {
        return bookServicePort.addBook(bookDto);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) throws Exception {
        bookServicePort.deleteBook(id);
    }



}
