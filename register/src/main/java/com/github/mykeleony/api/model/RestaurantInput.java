package com.github.mykeleony.api.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
@ToString
public class RestaurantInput {
    
    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    
    @NotNull
    @Size(min = 1, max = 255)
    private String owner;
    
    @NotNull
    @CNPJ
    private String cnpj;
    
    @NotNull
    @Valid
    private LocationInput location;
    
}
