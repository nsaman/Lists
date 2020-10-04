package com.lists.model;

/**
 * Created by nick on 10/28/2018.
 */

public class IntegerDescriptor extends Descriptor {

    private Integer value;

    public IntegerDescriptor() {
        super(DescriptorTypes.INTEGER);
    }

    @Override
    public String getReadableString() {
        return value!=null?value.toString():"";
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
