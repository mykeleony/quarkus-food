package com.github.mykeleony.domain.repository;

import com.github.mykeleony.domain.model.Restaurant;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RestaurantRepository implements PanacheRepositoryBase<Restaurant, Long> {
}
