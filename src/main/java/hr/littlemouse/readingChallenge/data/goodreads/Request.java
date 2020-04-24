package hr.littlemouse.readingChallenge.data.goodreads;

import lombok.Data;

@Data
public class Request {

    private String authentication;
    private String key;
    private String method;

   }
