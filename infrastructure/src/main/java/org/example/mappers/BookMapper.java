package org.example.mappers;

import java.util.List;
import org.example.data.BookDto;
import org.example.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    List<BookDto> bookListToBookDtoList(List<Book> bookList );

    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);
}
