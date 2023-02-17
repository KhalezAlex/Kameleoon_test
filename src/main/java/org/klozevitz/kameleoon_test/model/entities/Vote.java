package org.klozevitz.kameleoon_test.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vote_t")
@Getter
@Setter
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vote")
    private Boolean vote;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "quote_id")
    Quote quote;


//nullObject for Optional<Like> database responses
    public Vote() {
        this.id = -1L;
        this.vote = false;
        this.date = LocalDate.of(1000, 1, 1);
        this.quote = new Quote();
    }

    public Vote(Boolean vote, Quote quote) {
        this.vote = vote;
        this.date = LocalDate.now();
        this.quote = quote;
    }



    @Override
    public String toString() {
        return "{id=" + id +
                ", vote=" + vote +
                ", date=" + date +
                ", quote=" + quote + '}';
    }
}
