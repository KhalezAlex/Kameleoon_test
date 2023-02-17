package org.klozevitz.kameleoon_test.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user_t")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "registered")
    private LocalDate registered;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Quote> quotes;


// nullObject for further usages
    public User() {
        this.id = -1L;
        this.name = "undefined";
        this.email = "undefined";
        this.password = "undefined";
        this.registered = LocalDate.of(1000, 1, 1);
        this.quotes = new HashSet<>();
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registered = LocalDate.now();
        this.quotes = new HashSet<>();
    }

    public User(String name, String password) {
        this.name = name;
        this.email = "undefined";
        this.password = password;
        this.registered = LocalDate.now();
        this.quotes = new HashSet<>();
    }

    @Override
    public String toString() {
        return "{name='" + name +
                "', email='" + email +
                "', registered=" + registered + '}';
    }
}
