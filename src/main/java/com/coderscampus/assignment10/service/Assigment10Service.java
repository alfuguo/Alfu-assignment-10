package com.coderscampus.assignment10.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Optional;

@Service
public class Assigment10Service {
    @Value("${spoonacular.urls.base}")
    private String spoonacularUrls;

    @Value("${spoonacular.urls.mealplan}")
    private String spoonacularMealplan;

    @Value("${spoonacular.api.key}")
    private String apiKey;

    RestTemplate restTemplate = new RestTemplate();

    public<T> ResponseEntity<T> fetchDataFromSpoonacular (String timeFrame, String numCalories, String exclude, String diet, Class<T>responseClass) {
        String uri = buildUri(timeFrame, numCalories, exclude, diet);
        return restTemplate.getForEntity(uri, responseClass);
    }

    private String buildUri(String timeFrame, String numCalories, String exclude, String diet) {
        return UriComponentsBuilder.fromHttpUrl(spoonacularUrls + spoonacularMealplan )
                .queryParam("apiKey", apiKey)
                .queryParam("timeFrame", timeFrame)
                .queryParamIfPresent("targetCalories", Optional.ofNullable(numCalories))
                .queryParamIfPresent("exclude", Optional.ofNullable(exclude))
                .queryParamIfPresent("diet", Optional.ofNullable(diet))
                .build()
                .toUriString();

    }

}