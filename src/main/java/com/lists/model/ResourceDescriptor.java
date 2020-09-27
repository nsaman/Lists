package com.lists.model;

import javax.persistence.Entity;

/**
 * Created by nick on 10/28/2018.
 */

@Entity
public class ResourceDescriptor extends Descriptor {

    private String value;

    public ResourceDescriptor() {
        super(DescriptorTypes.RESOURCE);
    }

    @Override
    public String getReadableString() {
        return value;
    }

    public String getValue() {
        return value!=null?value:"";
    }

    public void setValue(String value) {
        this.value = value;
    }
}
