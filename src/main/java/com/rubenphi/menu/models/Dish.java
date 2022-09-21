package com.rubenphi.menu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;


import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "dishes")
@EntityListeners(AuditingEntityListener.class)
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter
    Long id;
    @Setter @Getter
    String name;
    @Setter @Getter
    Integer price;
    @Setter @Getter
    Boolean inMenu;
    @Setter @Getter
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    List<OrderDish> orders = new ArrayList<>();
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
