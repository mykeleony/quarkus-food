package com.github.mykeleony.domain.repository;

import com.github.mykeleony.domain.model.Dish;
import com.github.mykeleony.domain.model.Restaurant;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DishRepository implements PanacheRepositoryBase<Dish, Long> {

    public long countByRestaurant(Restaurant restaurant) {
        return count("restaurant", restaurant);
    }

}
