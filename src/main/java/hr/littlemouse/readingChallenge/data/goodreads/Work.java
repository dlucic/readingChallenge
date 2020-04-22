package hr.littlemouse.readingChallenge.data.goodreads;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Work {

    private Integer id;

    @XmlElement(name = "best_book")
    private BestBook bestBook;


}
