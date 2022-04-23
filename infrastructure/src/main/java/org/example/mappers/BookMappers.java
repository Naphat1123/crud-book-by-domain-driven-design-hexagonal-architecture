package org.example.mappers;

import java.util.ArrayList;
import java.util.List;
import org.example.data.BookDto;
import org.example.entity.Book;

public class BookMappers {

    public List<BookDto> bookListToBookDtoList(List<Book>bookList){
        List<BookDto> response = new ArrayList<>();
        for (Book book : bookList){
            BookDto result = new BookDto();
            result.setId(book.getId());
            result.setDescription(book.getDescription());
            result.setTitle(book.getTitle());
            result.setPrice(book.getPrice());
            response.add(result);
        }
        return response;
    }

}
