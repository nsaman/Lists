package com.lists.model;


/**
 * Created by nick on 10/28/2018.
 */

public class StringDescriptor extends Descriptor {

    private String value;

    public StringDescriptor() {
        super(DescriptorTypes.STRING);
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
