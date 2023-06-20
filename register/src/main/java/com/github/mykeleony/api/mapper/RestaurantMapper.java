package com.github.mykeleony.api.mapper;

import com.github.mykeleony.api.model.RestaurantInput;
import com.github.mykeleony.domain.model.Restaurant;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

@Singleton
@AllArgsConstructor
@Slf4j
public class RestaurantMapper {
    
    private ModelMapper modelMapper;
    
    public Restaurant toEntity(RestaurantInput restaurantInput) {
        log.info("Mapping restaurant's {} input model to entity", restaurantInput.getName());
        
        return modelMapper.map(restaurantInput, Restaurant.class);
    }
    
}
