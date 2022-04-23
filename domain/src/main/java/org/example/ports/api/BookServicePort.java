package org.example.ports.api;

import java.util.List;
import org.example.data.BookDto;

public interface BookServicePort {

    List<BookDto> getAllBook();

    BookDto getBookById(Long id) throws Exception;

    BookDto addBook(BookDto bookDto) throws Exception;

    void deleteBook(Long id) throws Exception;
}
