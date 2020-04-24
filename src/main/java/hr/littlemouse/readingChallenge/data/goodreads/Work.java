package hr.littlemouse.readingChallenge.data.goodreads;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Work {

    private Integer id;

    @XmlElement(name = "original_publication_year", defaultValue = "1991")
    private Integer publicationYear;

    @XmlElement(name = "original_publication_month", defaultValue = "1")
    private Integer publicationMonth;

    @XmlElement(name = "original_publication_day", defaultValue = "1")
    private Integer publicationDay;

    @XmlElement(name = "best_book")
    private BestBook bestBook;


}
