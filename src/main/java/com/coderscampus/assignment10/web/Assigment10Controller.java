package com.coderscampus.assignment10.web;

import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import com.coderscampus.assignment10.service.Assigment10Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class Assigment10Controller {
    @Autowired
    private Assigment10Service assigment10Service;


    @GetMapping("mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
        return assigment10Service.fetchDataFromSpoonacular("day", numCalories, diet, exclusions, DayResponse.class);
    }


    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions){

        return assigment10Service.fetchDataFromSpoonacular("week", numCalories, diet, exclusions, WeekResponse.class);
    }



}
