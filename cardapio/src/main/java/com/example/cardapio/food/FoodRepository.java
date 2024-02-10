package com.example.cardapio.food;

import org.springframework.data.jpa.repository.JpaRepository;

//classe que se conecta com o banco de dados e vai pegar os dados.
public interface FoodRepository extends JpaRepository<Food, Long> { //passar como parâmetro o tipo que o  repositorio vai retornar e o tipo de id

}
