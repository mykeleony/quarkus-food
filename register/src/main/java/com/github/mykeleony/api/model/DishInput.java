package com.github.mykeleony.api.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Getter
@Setter
public class DishInput {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;
    
    @NotNull
    @Length(min = 3, max = 255)
    private String description;
    
    @NotNull
    @DecimalMin("0.1")
    private BigDecimal unitPrice;
    
}
