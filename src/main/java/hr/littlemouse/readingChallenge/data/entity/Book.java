package hr.littlemouse.readingChallenge.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long book_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String nrOfPages;

    @Column(nullable = false)
    private String datePublished;

    @Column
    private String isbn;

    @Column(nullable = false)
    private Integer goodReadsId;

    @Column
    private String coverPic;


}
