package com.github.mykeleony.domain.service;

import com.github.mykeleony.domain.model.Dish;
import com.github.mykeleony.domain.model.DishId;
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
    
    public List<Dish> listByRestaurant(Long restaurantId) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        
        return repository.list("restaurant", restaurant);
    }

    public Dish findById(Long restaurantId, Long dishId) {
        DishId id = new DishId(dishId, restaurantService.findById(restaurantId));
        
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }
    
    @Transactional
    public Dish create(Long restaurantId, Dish dish) {
        Restaurant restaurant = restaurantService.findById(restaurantId);
        
        dish.setRestaurant(restaurant);
        dish.setId(repository.countByRestaurant(restaurant) + 1L);
        
        repository.persist(dish);
        
        return dish;
    }
    
    @Transactional
    public Dish update(Long restaurantId, Long dishId, Dish dish) {
        Dish existentDish = findById(restaurantId, dishId);
        
        existentDish.setName(dish.getName());
        repository.persist(existentDish);
        
        return existentDish;
    }
    
    @Transactional
    public void deleteById(Long restaurantId, Long dishId) {
        repository.delete(findById(restaurantId, dishId));
    }
    
}
