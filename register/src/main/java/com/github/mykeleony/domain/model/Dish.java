package com.github.mykeleony.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "dish")
@IdClass(DishId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish extends PanacheEntityBase {
    
    @Id
    private Long id;
    
    private String name;
    private String description;
    private BigDecimal unitPrice;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    
}
