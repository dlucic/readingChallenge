package hr.littlemouse.readingChallenge.data.entity;

import hr.littlemouse.readingChallenge.data.enumeration.Role;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String nrOfPages;

    @Column(nullable = false)
    private String datePublished;

    @Column
    private Role isbn;

    @Column(nullable = false)
    private Integer goodReadsId;

    @Column
    private String coverPic;


}
