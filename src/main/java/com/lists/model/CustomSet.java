package com.lists.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;

/**
 * Created by nick on 4/7/2019.
 */

public class CustomSet extends AuditedEntity {

    private Integer customSetID;
    private String title;

    @JsonManagedReference(value="customSetCustomSetThings")
    private Set<CustomSetThing> customSetThings;

    public Integer getCustomSetID() {
        return customSetID;
    }

    public void setCustomSetID(Integer customSetID) {
        this.customSetID = customSetID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<CustomSetThing> getCustomSetThings() {
        return customSetThings;
    }

    public void setCustomSetThings(Set<CustomSetThing> customSetThings) {
        this.customSetThings = customSetThings;
    }

}
