package com.rubenphi.menu.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dish_order")
@EntityListeners(AuditingEntityListener.class)
public class OrderDish {
    @EmbeddedId
    private OrderDishId id;

    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("orderId")
    private Order order;


    @Setter
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("dishId")
    private Dish dish;

    @Setter
    @Getter
    Integer amount;

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

    private OrderDish() {}

    public OrderDish(Order order, Dish dish) {
        this.order = order;
        this.dish = dish;
        this.id = new OrderDishId(order.getId(), dish.getId());
    }

    //Getters and setters omitted for brevity

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OrderDish that = (OrderDish) o;
        return Objects.equals(order, that.order) &&
                Objects.equals(dish, that.dish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, dish);
    }

}
