package com.coderscampus.assignment10.web;

import com.coderscampus.assignment10.dto.DayResponse;
import com.coderscampus.assignment10.dto.WeekResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class Assigment10Controller {
    @GetMapping("mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions){

        return null;
    }

    @GetMapping("mealplanner/day")

    public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions){
        return null;
    }

}
