package org.klozevitz.kameleoon_test.model.entities.dto;

import lombok.Data;
import org.klozevitz.kameleoon_test.model.entities.Quote;


import java.time.LocalDate;
import java.util.LinkedList;
/**
Data transfer entity
 -firstVoted and graphCords- data for diagrams
*/
@Data
public class QuoteDTO {
    private Quote quote;
    private Integer rate;
    private LocalDate firstVoted;
    private LinkedList<Integer> graphCords;

    public QuoteDTO(Quote quote, int rate, LocalDate firstVoted, LinkedList<Integer> graphCords) {
        this.quote = quote;
        this.rate = rate;
        this.firstVoted = firstVoted;
        this.graphCords = graphCords;
    }
}
