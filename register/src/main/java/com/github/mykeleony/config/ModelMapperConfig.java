package com.github.mykeleony.config;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class ModelMapperConfig {
    
    @Singleton
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
