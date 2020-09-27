package com.lists.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by nick on 9/28/2018.
 */

@Entity
public class Vote extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer voteID;

    @JsonBackReference(value="voteComparator")
    @ManyToOne
    @JoinColumn(name="comparatorID",foreignKey=@ForeignKey(name="FK_vote_1"))
    private Comparator comparator;

    @JsonBackReference(value="voteWinningThing")
    @ManyToOne
    @JoinColumn(name="winnerThingID",foreignKey=@ForeignKey(name="FK_vote_2"))
    private Thing winnerThing;

    @JsonBackReference(value="voteLoserThing")
    @ManyToOne
    @JoinColumn(name="loserThingID",foreignKey=@ForeignKey(name="FK_vote_3"))
    private Thing loserThing;

    @JsonBackReference(value="voteCustomSet")
    @ManyToOne
    @JoinColumn(name="customSetID",foreignKey=@ForeignKey(name="FK_vote_5"))
    private CustomSet customSet;

    @JsonBackReference(value="voteUserID")
    @ManyToOne
    @JoinColumn(name="userID",foreignKey=@ForeignKey(name="FK_vote_4"))
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
