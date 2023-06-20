package com.github.mykeleony.domain.repository;

import com.github.mykeleony.domain.model.Restaurant;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RestaurantRepository implements PanacheRepository<Restaurant> {
}
