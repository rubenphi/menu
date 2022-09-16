package com.rubenphi.menu.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String lastName;
    @Setter
    @Getter
    @Column(unique = true)
    private String code;
    @Setter
    @Getter
    private String password;
    @Setter
    @Getter
    private String role;
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
