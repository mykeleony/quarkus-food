package com.github.mykeleony.api.controller;

import com.github.mykeleony.domain.model.Restaurant;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@Path("/restaurants")
public class RestaurantController {
    
    @GET
    public List<Restaurant> listAllRestaurants() {
        return Restaurant.listAll();
    }

}
