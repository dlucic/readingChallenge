package hr.littlemouse.readingChallenge.data.goodreads;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class BestBook {

    @XmlAttribute
    private String type;

    private Integer id;

    private String title;

    private Author author;

    @XmlElement(name="image_url")
    private String imageUrl;
}
