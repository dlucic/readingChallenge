package hr.littlemouse.readingChallenge.data.goodreads;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Results {

    @XmlElement(name = "work")
    private List<Work> works;

}
