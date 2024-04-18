package com.coderscampus.assignment10.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

public class Assigment10Service {
    @Value("${spoonacular.urls.base}")
    private String spoonacularUrls;

    @Value("${spoonacular.urls.mealplan}")
    private String spoonacularMealplan;

    @Value("${spoonacular.api.key}")
    private String spoonacularApiKey;

    RestTemplate restTemplate = new RestTemplate();

    public<T> ResponseEntity<T> fetchDataFromSpoonacular (String timeFrame, String numCalories, String exclude, String diet, Class<T>responseClass) {
        URI uri = UriComponentsBuilder.fromHttpUrl(spoonacularUrls + spoonacularMealplan)
                .queryParam("apiKey" , spoonacularApiKey)
                .queryParam("timeFrame", timeFrame)
                .queryParam("targetCalories" , Optional.ofNullable(numCalories))
                .queryParam("exclude" , Optional.ofNullable(exclude))
                .queryParam("diet" , Optional.ofNullable(diet))
                .build()
                .toUri();

    return restTemplate.getForEntity(uri, responseClass);
    }
}
