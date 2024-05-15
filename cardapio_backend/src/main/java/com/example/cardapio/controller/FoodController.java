package com.example.cardapio.controller;

import com.example.cardapio.database.FoodRepository;
import com.example.cardapio.dto.FoodRequest;
import com.example.cardapio.dto.FoodResponse;
import com.example.cardapio.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {
    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponse> getAll(){
        List<FoodResponse> foodList = repository.findAll().stream().map(FoodResponse::new).toList();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequest data){
        Food newFood = new Food(data);
        repository.save(newFood);
    }
}
