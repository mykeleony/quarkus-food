package com.github.mykeleony.domain.repository;

import com.github.mykeleony.domain.model.Dish;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DishRepository implements PanacheRepositoryBase<Dish, Long> {
}
