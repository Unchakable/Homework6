package com.example.userService.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.CreationTimestamp;


import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor()
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Accessors(chain = true)
public class User {

    public User(String name, int age, String email, LocalDateTime createdAt) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.createdAt = createdAt;
    }

    @Id
    @ToString.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @ToString.Include
    @EqualsAndHashCode.Include
    private String name;

    @Column(nullable = false)
    @ToString.Include
    @EqualsAndHashCode.Include
    private String email;

    @Column(nullable = false)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer age;

    @Column(name = "created_at", nullable = false)
    @ToString.Include
    @EqualsAndHashCode.Include
    @CreationTimestamp
    private LocalDateTime createdAt;
}

