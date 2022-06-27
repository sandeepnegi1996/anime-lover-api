package com.animelove.AnimeLover;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

    @GetMapping("/")
    public String getStatus() {
        return "anime application is up and running ";
    }

    @GetMapping("/getAnimeQuote")
    public AnimeQuote randomAnimeQuote() {


        String url = "https://animechan.vercel.app/api/random";

        RestTemplate restTemplate = new RestTemplate();


        AnimeQuote result =restTemplate.getForObject(url,AnimeQuote.class);

        System.out.println(result);

            return result;


    }
}
