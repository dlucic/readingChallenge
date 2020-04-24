package hr.littlemouse.readingChallenge.data.goodreads;

import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
public class Results {

    @XmlElement(name = "work")
    private List<Work> works;

}
