package com.lists.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by nick on 10/28/2018.
 */

@Entity
public class ReferenceThingDescriptor extends Descriptor {

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="referenceThingID")
    private Thing referenceThing;

    public ReferenceThingDescriptor() {
        super(DescriptorTypes.REFERENCE_THING);
    }

    @Override
    public String getReadableString() {
        return referenceThing!=null?referenceThing.getTitle():"";
    }

    public Thing getReferenceThing() {
        return referenceThing;
    }

    public void setReferenceThing(Thing referenceThing) {
        this.referenceThing = referenceThing;
    }
}
