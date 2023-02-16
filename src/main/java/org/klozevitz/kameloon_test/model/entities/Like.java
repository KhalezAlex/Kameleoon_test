package org.klozevitz.kameloon_test.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "likes_t")
@Data
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "like", nullable = false)
    private Boolean like;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "quote_id", nullable = false)
    Quote quote;


//nullObject for Optional<Like> database responses
    public Like() {
        this.id = -1L;
        this.like = false;
        this.date = LocalDate.of(1000, 1, 1);
        this.quote = new Quote();
    }

    public Like(Boolean like, Quote quote) {
        this.like = like;
        this.date = LocalDate.now();
        this.quote = quote;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", like=" + like +
                ", date=" + date +
                ", quote=" + quote + '}';
    }
}
