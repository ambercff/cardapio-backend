package com.example.cardapio.controller;

import com.example.cardapio.food.Food;
import com.example.cardapio.food.FoodRepository;
import com.example.cardapio.food.FoodRequestDTO;
import com.example.cardapio.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food") //mapeando o request que vai cair nesse controller, nesse caso qualquer endpoint "food" vai cair aqui
public class FoodController {
    @Autowired //indicando para o Spring que ele vai fazer a injeção de qualquer dependencia que necessite dentro da classe foodcontroller
    private FoodRepository repository;

    @CrossOrigin(origins="*", allowedHeaders = "*") //se subir a aplicação alterar a origem e o allowedHeaders
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data){ //a anotacao request body indica que o parametro desse método é o body que veio no request
        Food foodData = new Food(data);
        repository.save(foodData);
    }
    @CrossOrigin(origins="*", allowedHeaders = "*") //se subir a aplicação alterar a origem e o allowedHeaders
    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }
}
