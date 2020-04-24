package hr.littlemouse.readingChallenge.data.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GoodReadsBookDTO {

    private String title;
    private String author;
    private String imageUrl;
    private LocalDate publicationDate;
}
