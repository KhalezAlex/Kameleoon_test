package org.klozevitz.kameleoon_test.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "quote_t")
@Getter
@Setter
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

    public int rate() {
        int rate = 0;
        for(Vote vote: votes) {
            if (vote.getVote())
                rate++;
            else
                rate--;
        }
        return rate;
    }

    @Override
    public String toString() {
        return "{content='" + content + "', updated=" + updated +
                ", user=" + user + '}';
    }
}
