package org.example.data;

import lombok.Data;

@Data
public class BookDto {

    private Long id;
    private String title;
    private String description;
    private Double price;

}
