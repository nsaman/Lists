package com.lists.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by nick on 9/28/2018.
 */

public class Vote extends AuditedEntity {
    private Integer voteID;

    @JsonBackReference(value="voteComparator")
    private Comparator comparator;

    @JsonBackReference(value="voteWinningThing")
    private Thing winnerThing;

    @JsonBackReference(value="voteLoserThing")
    private Thing loserThing;

    @JsonBackReference(value="voteCustomSet")
    private CustomSet customSet;

    @JsonBackReference(value="voteUserID")
    private UserStub user;

    public Integer getVoteID() {
        return voteID;
    }

    public void setVoteID(Integer voteID) {
        this.voteID = voteID;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public Thing getWinnerThing() {
        return winnerThing;
    }

    public void setWinnerThing(Thing winnerThing) {
        this.winnerThing = winnerThing;
    }

    public Thing getLoserThing() {
        return loserThing;
    }

    public void setLoserThing(Thing loserThing) {
        this.loserThing = loserThing;
    }

    public CustomSet getCustomSet() {
        return customSet;
    }

    public void setCustomSet(CustomSet customSet) {
        this.customSet = customSet;
    }

    public UserStub getUser() {
        return user;
    }

    public void setUser(UserStub user) {
        this.user = user;
    }
}
