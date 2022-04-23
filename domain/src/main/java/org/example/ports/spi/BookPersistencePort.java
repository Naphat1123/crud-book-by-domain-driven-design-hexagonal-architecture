package org.example.ports.spi;

import java.util.List;
import org.example.data.BookDto;

public interface BookPersistencePort {

    List<BookDto> getAllBook();

    void deleteBookById(Long id) throws Exception;

    BookDto addBook(BookDto bookDto) throws Exception;

    BookDto getBookById(Long id) throws Exception;
}
