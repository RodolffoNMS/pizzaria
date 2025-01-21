package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PizzaDTO;
import com.zup.pizzaria.models.Pizza;
import com.zup.pizzaria.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping
    public ResponseEntity<Pizza> create (@RequestBody PizzaDTO pizzaDTO){
        Pizza pizza = pizzaService.criarPizza(pizzaDTO);
        return ResponseEntity.ok(pizza);
    }

    @GetMapping
    public ResponseEntity<List<Pizza>>getAllPizzas() {
        List<Pizza> pizzas = pizzaService.getTodasPizzas();
        return ResponseEntity.ok(pizzas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
        return pizzaService.getPizzaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @RequestBody PizzaDTO pizzaDTO) {
        Pizza updatedPizza = pizzaService.atualizaPizza(id, pizzaDTO);
        return ResponseEntity.ok(updatedPizza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        pizzaService.deletaPizza(id);
        return ResponseEntity.noContent().build();
    }


}
