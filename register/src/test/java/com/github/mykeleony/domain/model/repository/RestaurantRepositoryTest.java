package com.github.mykeleony.domain.model.repository;

import com.github.mykeleony.common.RestaurantConstants;
import com.github.mykeleony.domain.model.Restaurant;
import com.github.mykeleony.domain.repository.RestaurantRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;

import static com.github.mykeleony.common.RestaurantConstants.RESTAURANT;
import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
@TestTransaction
@QuarkusTestResource(H2DatabaseTestResource.class)
public class RestaurantRepositoryTest {
    
    @Inject
    public RestaurantRepository repository;
    
    @PersistenceContext
    public EntityManager entityManager;
    
    @Test
    public void createRestaurant_WithValidData_ReturnsRestaurant() {
        repository.persist(RESTAURANT);
        
        Restaurant sut = entityManager.find(Restaurant.class, RESTAURANT.getId());
        
        assertThat(sut).isNotNull();
        assertThat(sut.getName()).isEqualTo(RESTAURANT.getName());
        assertThat(sut.getCnpj()).isEqualTo(RESTAURANT.getCnpj());
        assertThat(sut.getOwner()).isEqualTo(RESTAURANT.getOwner());
        assertThat(sut.getLocation()).isEqualTo(RESTAURANT.getLocation());
        assertThat(sut.getCreationDate()).isEqualTo(RESTAURANT.getCreationDate());
        assertThat(sut.getUpdateDate()).isEqualTo(RESTAURANT.getUpdateDate());
    }

}
