package com.demo.controller;

import com.demo.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class WeatherController {

    @Value("${weather.api.key}")
    private String apiKey;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/getWeather")
    public String getWeather(@RequestParam String city, Model model) {
        //String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";    //stander way
        String url = UriComponentsBuilder.fromHttpUrl("https://api.openweathermap.org/data/2.5/weather")                      //understanding way. by this statment pass the url and get the response 
        	    .queryParam("q", city)
        	    .queryParam("appid", apiKey)
        	    .queryParam("units", "metric")
        	    .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        if (response != null && response.getMain() != null) {
            model.addAttribute("temp", response.getMain().getTemp());
            model.addAttribute("humidity", response.getMain().getHumidity());
            model.addAttribute("description", response.getWeather().get(0).getDescription());
            model.addAttribute("city", city);
        } else {
            model.addAttribute("error", "City not found or API issue.");
        }
        return "results";
    }
}
