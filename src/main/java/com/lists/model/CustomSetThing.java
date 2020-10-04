package com.lists.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by nick on 4/7/2019.
 */

public class CustomSetThing extends AuditedEntity {

    private Integer customSetThingID;

    @JsonBackReference(value="customSetCustomSetThings")
    private CustomSet customSet;

    @JsonBackReference(value="thingCustomSetThings")
    private Thing thing;

    private Boolean logicallyDeleted;

    public CustomSet getCustomSet() {
        return customSet;
    }

    public void setCustomSet(CustomSet customSet) {
        this.customSet = customSet;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    public Integer getCustomSetThingID() {
        return customSetThingID;
    }

    public void setCustomSetThingID(Integer customSetThingID) {
        this.customSetThingID = customSetThingID;
    }

    public Boolean getLogicallyDeleted() {
        return logicallyDeleted;
    }

    public void setLogicallyDeleted(Boolean logicallyDeleted) {
        this.logicallyDeleted = logicallyDeleted;
    }
}
