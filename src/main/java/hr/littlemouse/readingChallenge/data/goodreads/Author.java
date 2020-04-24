package hr.littlemouse.readingChallenge.data.goodreads;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Author {
    
    private String name;
}
