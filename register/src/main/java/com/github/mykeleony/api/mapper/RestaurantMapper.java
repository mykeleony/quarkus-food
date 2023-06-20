package com.github.mykeleony.api.mapper;

import com.github.mykeleony.api.model.RestaurantInput;
import com.github.mykeleony.domain.model.Restaurant;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

@Singleton
@AllArgsConstructor
public class RestaurantMapper {
    
    private ModelMapper modelMapper;
    
    public Restaurant toEntity(RestaurantInput restaurantInput) {
        return modelMapper.map(restaurantInput, Restaurant.class);
    }
    
}
