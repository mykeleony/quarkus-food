package com.github.mykeleony.domain.service;

import com.github.mykeleony.domain.model.Dish;
import com.github.mykeleony.domain.model.Restaurant;
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
    private RestaurantService restaurantService;
    
    public List<Dish> listAll() {
       return repository.listAll();
    }

    public Dish findById(Long id) {
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }
    
    @Transactional
    public Dish create(Long restaurantId, Dish dish) {
        dish.setRestaurant(restaurantService.findById(restaurantId));
        
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
