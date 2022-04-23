package org.example.service;

import java.util.List;
import org.example.data.BookDto;
import org.example.ports.api.BookServicePort;
import org.example.ports.spi.BookPersistencePort;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookServicePort {

    private final BookPersistencePort bookPersistencePort;

    public BookServiceImpl(BookPersistencePort bookPersistencePort) {
        this.bookPersistencePort = bookPersistencePort;
    }

    @Override
    public List<BookDto> getAllBook() {
        return bookPersistencePort.getAllBook();
    }

    @Override
    public BookDto getBookById(Long id) throws Exception {
        return bookPersistencePort.getBookById(id);
    }

    @Override
    public BookDto addBook(BookDto bookDto) throws Exception {
        return bookPersistencePort.addBook(bookDto);
    }

    @Override
    public void deleteBook(Long id) throws Exception {
        bookPersistencePort.deleteBookById(id);
    }
}
