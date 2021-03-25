package com.github.djnautiyal.custommetrics.service;

import com.github.djnautiyal.custommetrics.model.Person;
import io.micrometer.core.annotation.Timed;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EatingService {

    Map<String, Person> list;

    public EatingService(){
        list = new HashMap<>();
    }

    @Timed
    public boolean eatFood(String p,String f){

        if(!list.containsKey(p)){
            Person person = new Person(p, f);
            list.put(p,person);
            return true;
        }else if(!list.get(p).hasEaten(f)){
            list.get(p).eatsFood(f);
            return true;
        }
        else{
            return false;
        }


    }
}
