package org.klozevitz.kameleoon_test.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_t")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "regDate")
    private LocalDate regDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Quote> quotes;



// nullObject for further usages
    public User() {
        this.id = -1L;
        this.name = "undefined";
        this.email = "undefined";
        this.password = "undefined";
        this.regDate = LocalDate.of(1000, 1, 1);
        this.quotes = new HashSet<>();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.regDate = LocalDate.now();
    }

    public User(String name, String password) {
        this.name = name;
        this.email = "undefined";
        this.password = password;
        this.regDate = LocalDate.now();
    }

    @Override
    public String toString() {
        return "{name='" + name +
                "', email='" + email +
                "', regDate=" + regDate + '}';
    }
}
