package com.rubenphi.menu.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hashids.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter
    @Getter
    Long id;
    @Setter @Getter
    String code;
    @PreUpdate
    @PostPersist
    public void hashing(){
        Hashids hashids = new Hashids("secureSalt",6,"0123456789abcdefghijklmnopqrstuvwxyz");
        this.setCode(hashids.encode(id));
    }
    @Setter @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User waiter;
    @Setter @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private RestaurantTable table;
    @Setter @Getter
    @OneToMany(mappedBy = "order")
    Set<OrderDish> orderDishes;
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
