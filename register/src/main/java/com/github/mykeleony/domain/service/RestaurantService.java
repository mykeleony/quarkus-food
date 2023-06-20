package com.github.mykeleony.domain.service;

import com.github.mykeleony.domain.model.Restaurant;
import com.github.mykeleony.domain.repository.RestaurantRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@ApplicationScoped
@AllArgsConstructor
@Slf4j
public class RestaurantService {
    
    private RestaurantRepository restaurantRepository;
    
    public List<Restaurant> listAll() {
        log.info("Listing all restaurants:");
        
        return restaurantRepository.listAll();
    }
    
    public Restaurant findById(Long id) {
        log.info("Searching restaurant with id {}:", id);
        
        return restaurantRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }
    
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        log.info("Saving restaurant {}:", restaurant);
        
        restaurantRepository.persist(restaurant);
        
        return restaurant;
    }
    
    @Transactional
    public Restaurant update(Long id, Restaurant restaurant) {
        Restaurant existingRestaurant = findById(id);
        
        existingRestaurant.setName(restaurant.getName());
        
        restaurantRepository.persist(existingRestaurant);
        
        return existingRestaurant;
    }
    
    @Transactional
    public void deleteById(Long id) {
        findById(id);
        
        log.info("Deleting restaurant with id {}", id);
        
        restaurantRepository.deleteById(id);
    }
    
}
