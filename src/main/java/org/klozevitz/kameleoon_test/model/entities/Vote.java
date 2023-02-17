package org.klozevitz.kameleoon_test.model.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "vote_t")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getVote() {
        return vote;
    }

    public void setVote(Boolean vote) {
        this.vote = vote;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

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
