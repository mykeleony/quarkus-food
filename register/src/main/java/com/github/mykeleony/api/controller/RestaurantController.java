package com.github.mykeleony.api.controller;

import com.github.mykeleony.api.mapper.RestaurantMapper;
import com.github.mykeleony.api.model.RestaurantInput;
import com.github.mykeleony.domain.model.Restaurant;
import com.github.mykeleony.domain.service.RestaurantService;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Path("/restaurants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@AllArgsConstructor
public class RestaurantController {
    
    private RestaurantMapper mapper;
    private RestaurantService service;
    
    @GET
    public List<Restaurant> listAll() {
        return service.listAll();
    }
    
    @POST
    public Restaurant create(RestaurantInput restaurantInput) {
        Restaurant restaurant = mapper.toEntity(restaurantInput);
        
        return service.save(restaurant);
    }
    
    @PUT
    @Path("/{id}")
    public Restaurant update(@PathParam("id") Long id, RestaurantInput restaurantInput) {
        Restaurant restaurant = mapper.toEntity(restaurantInput);
        
        return service.update(id, restaurant);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteById(@PathParam("id") Long id) {
        service.deleteById(id);
    }

}
