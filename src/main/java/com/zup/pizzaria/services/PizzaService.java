package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PizzaDTO;
import com.zup.pizzaria.models.Pizza;
import com.zup.pizzaria.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public Pizza criarPizza(PizzaDTO pizzaDTO) {
        Pizza pizza = new Pizza();
        pizza.setNome(pizzaDTO.getNome());
        pizza.setDescricao(pizzaDTO.getDescricao());
        pizza.setPreco(pizzaDTO.getPreco());
        return pizzaRepository.save(pizza);
    }
    public List<Pizza> getTodasPizzas() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> getPizzaPorId(Long id) {
        return pizzaRepository.findById(id);
    }

    public Pizza atualizaPizza(Long id, PizzaDTO pizzaDTO) {
        Pizza pizza = pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza not found"));
        pizza.setNome(pizzaDTO.getNome());
        pizza.setDescricao(pizzaDTO.getDescricao());
        pizza.setPreco(pizzaDTO.getPreco());
        return pizzaRepository.save(pizza);
    }

    public void deletaPizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}
