package hr.littlemouse.readingChallenge.services;

import hr.littlemouse.readingChallenge.data.dto.GoodReadsBookDTO;
import hr.littlemouse.readingChallenge.data.goodreads.GoodreadsResponse;
import hr.littlemouse.readingChallenge.data.mapping.GoodReadsBookMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXB;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoodReadsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodReadsService.class);

    private final GoodReadsBookMapper goodReadsBookMapper;

    @Value("${goodReadsSearch}")
    private String goodReadsSearch;

    public List<GoodReadsBookDTO> getBookByName(String bookName) {

        URL xmlUri = null;

        try {
            xmlUri = new URL(goodReadsSearch + URLEncoder.encode(bookName, "UTF-8"));
        } catch (UnsupportedEncodingException | MalformedURLException e) {
            e.printStackTrace();
        }
        return goodReadsRequest(xmlUri).getSearch().getResults().getWorks()
                .stream()
                .map(goodReadsBookMapper::goodReadsBookToGoodReadsBookDTO)
                .collect(Collectors.toList());
    }

    private static GoodreadsResponse goodReadsRequest(URL xmlUrl) {

        return JAXB.unmarshal(xmlUrl, GoodreadsResponse.class);

    }

}
