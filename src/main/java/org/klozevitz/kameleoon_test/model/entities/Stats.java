package org.klozevitz.kameleoon_test.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "stats_t")
@Data
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stat")
    private Boolean stat;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "quote_id")
    Quote quote;


//nullObject for Optional<Like> database responses
    public Stats() {
        this.id = -1L;
        this.stat = false;
        this.date = LocalDate.of(1000, 1, 1);
        this.quote = new Quote();
    }

    public Stats(Boolean stat, Quote quote) {
        this.stat = stat;
        this.date = LocalDate.now();
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", stat=" + stat +
                ", date=" + date +
                ", quote=" + quote + '}';
    }
}
