package com.lists.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by nick on 9/25/2018.
 */

public class Compares extends AuditedEntity {

    public static float DEFAULT_SCORE = 1600;

    private Integer comparesID;

    private Comparator comparator;

    @JsonBackReference(value="thingCompares")
    private Thing thing;

    @JsonBackReference(value="customSetCompares")
    private CustomSet customSet;

    private float score;

    public Integer getComparesID() {
        return comparesID;
    }

    public void setComparesID(Integer comparesID) {
        this.comparesID = comparesID;
    }

    public Comparator getComparator() {
        return comparator;
    }

    public void setComparator(Comparator comparator) {
        this.comparator = comparator;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public CustomSet getCustomSet() {
        return customSet;
    }

    public void setCustomSet(CustomSet customSet) {
        this.customSet = customSet;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
