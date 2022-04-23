package org.example.adapter;

import java.util.List;
import java.util.Optional;
import org.example.data.BookDto;
import org.example.entity.Book;
import org.example.mappers.BookMapper;
import org.example.ports.spi.BookPersistencePort;
import org.example.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class BookAdapter implements BookPersistencePort {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookAdapter(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getAllBook() {
        List<Book> all = bookRepository.findAll();
        return bookMapper.bookListToBookDtoList(all);
    }

    @Override
    public void deleteBookById(Long id) throws Exception {
        if (ObjectUtils.isEmpty(id)) {
            throw new Exception("id is empty");
        }

        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new Exception("book id is not exist");
        }
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception("can't not delete book");
        }
    }

    @Override
    public BookDto addBook(BookDto bookDto) throws Exception {

        if (ObjectUtils.isEmpty(bookDto)) {
            throw new Exception("data is empty");
        }
        Book book = bookMapper.bookDtoToBook(bookDto);
        Book save;

        try {
            save = bookRepository.save(book);
        } catch (Exception e) {
            throw e;
        }
        return bookMapper.bookToBookDto(save);
    }

    @Override
    public BookDto getBookById(Long id) throws Exception {
        if (ObjectUtils.isEmpty(id)) {
            throw new Exception("id is empty");
        }

        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) {
            throw new Exception("book id is not exist");
        }

        return bookMapper.bookToBookDto(bookOptional.get());
    }
}
