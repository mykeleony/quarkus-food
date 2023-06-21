package com.github.mykeleony.api.mapper;

import com.github.mykeleony.api.model.DishInput;
import com.github.mykeleony.domain.model.Dish;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

@ApplicationScoped
@AllArgsConstructor
public class DishMapper {
    
    private ModelMapper mapper;
    
    public Dish toEntity(DishInput dishInput) {
        return mapper.map(dishInput, Dish.class);
    }
    
    public void modifyEntityFields(DishInput dishInput, Dish dish) {
        mapper.map(dishInput, dish);
    }
    
}
