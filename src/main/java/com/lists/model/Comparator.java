package com.lists.model;

/**
 * Created by nick on 6/5/2018.
 */
public class Comparator extends AuditedEntity {

    private Integer comparatorID;
    private String title;

    public Integer getComparatorID() {
        return comparatorID;
    }

    public void setComparatorID(Integer comparatorID) {
        this.comparatorID = comparatorID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
