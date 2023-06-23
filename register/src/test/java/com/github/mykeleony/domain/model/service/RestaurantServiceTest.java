package com.github.mykeleony.domain.model.service;

import com.github.mykeleony.common.RestaurantConstants;
import com.github.mykeleony.domain.model.Restaurant;
import com.github.mykeleony.domain.repository.RestaurantRepository;
import com.github.mykeleony.domain.service.RestaurantService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static com.github.mykeleony.common.RestaurantConstants.RESTAURANT;
import static com.github.mykeleony.common.RestaurantConstants.RESTAURANTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@QuarkusTest
public class RestaurantServiceTest {

    @Inject
    public RestaurantService service;
    
    @InjectMock
    public RestaurantRepository repository;
    
    @Test
    public void listRestaurants_ReturnsAllRestaurants() {
        when(repository.listAll()).thenReturn(RESTAURANTS);
        
        List<Restaurant> sut = service.listAll();
        
        assertThat(sut)
                .isNotNull()
                .hasSize(RESTAURANTS.size());
        assertThat(sut.get(0)).isEqualTo(RESTAURANT);
    }
    
}
