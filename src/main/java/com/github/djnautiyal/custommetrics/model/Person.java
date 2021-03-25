package com.github.djnautiyal.custommetrics.model;

import java.util.HashSet;
import java.util.Set;

public class Person {

    String name;
    Set<String> foodEaten;

    public String getName(){
        return name;
    }

    public Person(String name, String food){
        this.name = name;
        this.foodEaten = new HashSet<>();
        this.foodEaten.add(food);
    }

    public void eatsFood(String food){
        this.foodEaten.add(food);
    }

    public boolean hasEaten(String food){
        return this.foodEaten.contains(food);
    }
}
