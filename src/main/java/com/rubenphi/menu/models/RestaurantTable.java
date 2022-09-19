package com.rubenphi.menu.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "restaurant_tables")
@EntityListeners(AuditingEntityListener.class)
public class RestaurantTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    Long id;
    @Setter @Getter
    String name;
    @Setter @Getter
    String location;
    @Setter
    @Getter
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private String createdAt;
    @Setter
    @Getter
    @LastModifiedDate
    @Column(name = "updated_at")
    private String updatedAt;

}
