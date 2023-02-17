package org.klozevitz.kameleoon_test.model.dao.services.utilities;

import org.klozevitz.kameleoon_test.model.entities.Vote;

import java.util.Comparator;

public class VoteIdComparator implements Comparator<Vote> {

    @Override
    public int compare(Vote v1, Vote v2) {
        if (v1.getId().equals(v2.getId())) return 0;
        if (v1.getId() > v2.getId()) return 1;
        else return -1;
    }
}
