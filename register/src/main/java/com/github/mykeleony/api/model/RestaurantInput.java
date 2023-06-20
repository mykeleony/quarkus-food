package com.github.mykeleony.api.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RestaurantInput {
    
    private String name;
    private String owner;
    private String cnpj;
    private LocationInput location;
    
}
