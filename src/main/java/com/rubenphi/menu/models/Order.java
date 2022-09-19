package com.rubenphi.menu.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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
    @Setter @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @Setter @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private RestaurantTable table;
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
