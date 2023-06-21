package com.github.mykeleony.api.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DishInput {
    
    private String name;
    private String description;
    private BigDecimal unitPrice;
    
}
