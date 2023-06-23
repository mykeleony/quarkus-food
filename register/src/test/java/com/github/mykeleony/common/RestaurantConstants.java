package com.github.mykeleony.common;

import com.github.mykeleony.domain.model.Location;
import com.github.mykeleony.domain.model.Restaurant;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class RestaurantConstants {
    
    private static final Location LOCATION = new Location(1.0, 1.0);
    private static final LocalDate DATE = LocalDate.of(2023, Month.JUNE, 22);
    
    public static final Restaurant RESTAURANT = new Restaurant("restaurant", "owner", "55.351.632/0001-91", LOCATION, DATE, DATE);
    
    public static final Restaurant INVALID_RESTAURANT = new Restaurant("", "", "", null, null, null);
    
    public static final List<Restaurant> RESTAURANTS = new ArrayList<>() {
        {
            int restaurantsAmount = 3;
            
            for (int i = 0; i < restaurantsAmount; i++) {
                add(RESTAURANT);
            }
        }
    };
    
}
