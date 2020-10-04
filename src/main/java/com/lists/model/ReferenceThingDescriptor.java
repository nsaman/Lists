package com.lists.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by nick on 10/28/2018.
 */
public class ReferenceThingDescriptor extends Descriptor {

    @JsonBackReference
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
