package com.github.mykeleony.api.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LocationInput {
    
    @NotNull
    private Double latitude;
    
    @NotNull
    private Double longitude;
    
}
