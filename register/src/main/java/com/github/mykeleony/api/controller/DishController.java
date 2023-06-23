package com.github.mykeleony.api.controller;

import com.github.mykeleony.api.mapper.DishMapper;
import com.github.mykeleony.api.model.DishInput;
import com.github.mykeleony.domain.model.Dish;
import com.github.mykeleony.domain.service.DishService;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

import java.util.List;

@Path("/{restaurantId}/dishes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class DishController {
    
    private DishService service;
    private DishMapper mapper;
    
    @GET
    public List<Dish> listByRestaurant(@PathParam("restaurantId") Long restaurantId) {
        return service.listByRestaurant(restaurantId);
    }
    
    @POST
    public Dish create(@PathParam("restaurantId") Long restaurantId, @Valid DishInput dishInput) {
        Dish dish = mapper.toEntity(dishInput);
        
        return service.create(restaurantId, dish);
    }
    
    @PUT
    @Path("/{dishId}")
    public Dish update(@PathParam("restaurantId") Long restaurantId, @PathParam("dishId") Long dishId, @Valid DishInput dishInput) {
        Dish dish = service.findById(restaurantId, dishId);
        
        mapper.modifyEntityFields(dishInput, dish);
        
        return dish;
    }
    
    @DELETE
    @Path("/{dishId}")
    public void deleteById(@PathParam("restaurantId") Long restaurantId, @PathParam("dishId") Long dishId) {
        service.deleteById(restaurantId, dishId);
    }
    
}
