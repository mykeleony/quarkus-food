package com.github.mykeleony.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String owner;
    private String cnpj;
    
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "location_id")
    private Location location;
    
    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDate creationDate;
    
    @UpdateTimestamp
    @Column(name = "update_date")
    private LocalDate updateDate;
    
    public Restaurant(String name, String owner, String cnpj, Location location, LocalDate creationDate, LocalDate updateDate) {
        this.name = name;
        this.owner = owner;
        this.cnpj = cnpj;
        this.location = location;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        
        if (!(o instanceof Restaurant that)) return false;
        
        return new EqualsBuilder().append(getId(), that.getId()).isEquals();
    }
    
    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(getId()).toHashCode();
    }
}
