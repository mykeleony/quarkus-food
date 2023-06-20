package com.github.mykeleony.domain.service;

import com.github.mykeleony.domain.model.Dish;
import com.github.mykeleony.domain.repository.DishRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;

import java.util.List;

@ApplicationScoped
@AllArgsConstructor
public class DishService {
    
    private DishRepository repository;
    
    public List<Dish> listAll() {
       return repository.listAll();
    }

    public Dish findById(Long id) {
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }
    
    @Transactional
    public Dish create(Dish dish) {
        repository.persist(dish);
        
        return dish;
    }
    
    @Transactional
    public Dish update(Long id, Dish dish) {
        Dish existentDish = findById(id);
        
        existentDish.setName(dish.getName());
        repository.persist(existentDish);
        
        return existentDish;
    }
    
    @Transactional
    public void deleteById(Long id) {
        findById(id);
        
        repository.deleteById(id);
    }
    
}
