package com.animelove.AnimeLover;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;

@RestController
public class MainController {

    @GetMapping("/")
    public String getStatus() {
        return "anime application is up and running ";
    }

    @GetMapping("/getAnimeQuote")
    public String randomAnimeQuote() {
        String url = "https://animechan.vercel.app/api/random";
        RestTemplate restTemplate = new RestTemplate();
        AnimeQuote result =restTemplate.getForObject(url,AnimeQuote.class);
        System.out.println(result.getQuote());



        return result.getQuote();
    }

    @GetMapping("/pic")
    public ResponseEntity<String> getAnimePic() {

        System.out.println("Inside Get Anime Pic...  ");

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "Application");

        HttpEntity<String> entity =  new HttpEntity<>(headers);

        String url = "https://api.waifu.pics/sfw/kill";
        RestTemplate restTemplate = new RestTemplate();

//        String response = restTemplate.getForObject(url, String.class);

      ResponseEntity<String> responseJson =  restTemplate.exchange(url, HttpMethod.GET,entity,String.class);

        System.out.println(responseJson);

        return responseJson;

    }
}
