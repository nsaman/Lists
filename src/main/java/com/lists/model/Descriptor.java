package com.lists.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by nick on 1/24/2018.
 */

@MappedSuperclass
public abstract class Descriptor extends AuditedEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer descriptorID;

    @JsonBackReference(value="descriptorDescribedThing")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="describedThingID")
    private Thing describedThing;

    @ManyToOne
    @JoinColumn(name="descriptorTypeID")
    private DescriptorType descriptorType;

    public abstract String getReadableString();

    @Transient
    final public DescriptorTypes type;

    Descriptor(DescriptorTypes type) {
        this.type = type;
    }

    public Integer getDescriptorID() {
        return descriptorID;
    }

    public void setDescriptorID(Integer descriptorID) {
        this.descriptorID = descriptorID;
    }

    public Thing getDescribedThing() {
        return describedThing;
    }

    public void setDescribedThing(Thing describedThing) {
        this.describedThing = describedThing;
    }

    public DescriptorType getDescriptorType() {
        return descriptorType;
    }

    public void setDescriptorType(DescriptorType descriptorType) {
        this.descriptorType = descriptorType;
    }

    public DescriptorTypes getType() {
        return type;
    }

}
