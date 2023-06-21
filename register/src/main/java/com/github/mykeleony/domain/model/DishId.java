package com.github.mykeleony.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DishId implements Serializable {
    
    private Long id;
    private Restaurant restaurant;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishId dishId)) return false;
        return Objects.equals(getId(), dishId.getId()) && Objects.equals(getRestaurant(), dishId.getRestaurant());
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRestaurant());
    }
    
}
