package com.github.djnautiyal.custommetrics.controller;

import com.github.djnautiyal.custommetrics.service.EatingService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodController {

    @Autowired
    EatingService eatingService;

    @Timed
    @GetMapping("{person}/eats/{food}")
    public String eatFood(@PathVariable("person") String person, @PathVariable("food") String food){

        Boolean response = eatingService.eatFood(person, food);

        if(response)
            return "Nice";
        else return "Oh Shit";
    }
}
