package org.klozevitz.kameleoon_test.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "quote_t")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

// perhaps final variable "= LocalDate.now()"
    @Column(name = "updated")
    private LocalDate updated;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "quote")
    Set<Vote> votes;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    // nullObject for Optional<Quote> database responses
    public Quote() {
        this.id = -1L;
        this.content = "undefined";
        this.updated = LocalDate.of(1000, 1, 1);
        this.user = new User();
        this.votes = new HashSet<>();
    }

    public Quote(String content, User user) {
        this.content = content;
        this.updated = LocalDate.now();
        this.user = user;
        this.votes = new HashSet<>();
    }

    public Quote(Long id, String content) {
        this.id = id;
        this.updated = LocalDate.now();
        this.content = content;
        this.votes = new HashSet<>();
    }

    @Override
    public String toString() {
        return "{content='" + content + "', updated=" + updated +
                ", user=" + user + '}';
    }
}
