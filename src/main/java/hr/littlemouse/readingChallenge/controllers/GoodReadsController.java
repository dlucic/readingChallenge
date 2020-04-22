package hr.littlemouse.readingChallenge.controllers;

import hr.littlemouse.readingChallenge.data.dto.GoodReadsBookDTO;
import hr.littlemouse.readingChallenge.data.goodreads.Work;
import hr.littlemouse.readingChallenge.services.GoodReadsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/goodreads")
public class GoodReadsController {

    private final GoodReadsService goodReadsService;

    @GetMapping(path = "/search/{bookName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GoodReadsBookDTO> searchByBookName(@PathVariable("bookName") String bookName){
        return goodReadsService.getBookByName(bookName);
    }



}
