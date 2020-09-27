package com.lists.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by nick on 4/7/2019.
 */

@Entity
public class CustomSetThing extends AuditedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customSetThingID;

    @JsonBackReference(value="customSetCustomSetThings")
    @ManyToOne
    @JoinColumn(name="customSetID",foreignKey=@ForeignKey(name="FK_customSetThing_1"))
    private CustomSet customSet;

    @JsonBackReference(value="thingCustomSetThings")
    @ManyToOne
    @JoinColumn(name="thingID",foreignKey=@ForeignKey(name="FK_customSetThing_2"))
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
