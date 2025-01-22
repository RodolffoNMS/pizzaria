package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.PizzaDTO;
import com.zup.pizzaria.models.Pizza;
import com.zup.pizzaria.services.PizzaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public ResponseEntity<Pizza> criarPizza(@Valid @RequestBody PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaService.createPizza(pizzaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizza);
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> getTodasPizzas() {
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        return ResponseEntity.ok(pizzas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaPorId(@PathVariable Long id) {
        return pizzaService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> atualizaPizza(@PathVariable Long id, @Valid @RequestBody PizzaDTO pizzaDTO) {
        Pizza updatedPizza = pizzaService.atualizaPizza(id, pizzaDTO);
        return ResponseEntity.ok(updatedPizza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaPizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }
}