package com.github.mykeleony.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "restaurant")
public class Restaurant extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String owner;
    private String cnpj;
    
    @OneToOne
    private Location location;
    
    @CreationTimestamp
    private LocalDate creationDate;
    
    @UpdateTimestamp
    private LocalDate updateDate;

}
