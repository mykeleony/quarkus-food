package com.github.mykeleony.domain.model.service;

import com.github.mykeleony.domain.model.Restaurant;
import com.github.mykeleony.domain.repository.RestaurantRepository;
import com.github.mykeleony.domain.service.RestaurantService;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static com.github.mykeleony.common.RestaurantConstants.RESTAURANT;
import static com.github.mykeleony.common.RestaurantConstants.RESTAURANTS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@QuarkusTest
public class RestaurantServiceTest {

    @Inject
    public RestaurantService service;
    
    @InjectMock
    public RestaurantRepository repository;
    
    @Test
    public void listRestaurants_withRegisteredRestaurants_ReturnsAllRestaurants() {
        when(repository.listAll()).thenReturn(RESTAURANTS);
        
        List<Restaurant> sut = service.listAll();
        
        assertThat(sut)
                .isNotNull()
                .hasSize(RESTAURANTS.size());
        assertThat(sut.get(0)).isEqualTo(RESTAURANT);
    }
    
    @Test
    public void listRestaurants_withoutRegisteredRestaurants_ReturnsEmpty() {
        assertThat(service.listAll()).isEmpty();
    }
    
    @Test
    public void findRestaurant_WithExistingId_ReturnsRestaurant() {
        when(repository.findByIdOptional(anyLong())).thenReturn(Optional.of(RESTAURANT));
        
        Restaurant sut = service.findById(1L);
        
        assertThat(sut).isNotNull();
        assertThat(sut.getName()).isEqualTo(RESTAURANT.getName());
        assertThat(sut.getCnpj()).isEqualTo(RESTAURANT.getCnpj());
        assertThat(sut.getOwner()).isEqualTo(RESTAURANT.getOwner());
        assertThat(sut.getLocation()).isEqualTo(RESTAURANT.getLocation());
        assertThat(sut.getCreationDate()).isEqualTo(RESTAURANT.getCreationDate());
        assertThat(sut.getUpdateDate()).isEqualTo(RESTAURANT.getUpdateDate());
    }
    
    @Test
    public void findRestaurant_WithNonexistentId_ThrowsException() {
        assertThatThrownBy(() -> service.findById(99L)).isInstanceOf(NotFoundException.class);
    }
    
}
