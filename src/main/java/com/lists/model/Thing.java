package com.lists.model;


import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by nick on 1/23/2018.
 */

@Data
@DynamoDBDocument
@DynamoDBTable(tableName = Thing.TABLE_NAME)
public class Thing extends AuditedEntity {

    public static final String TABLE_NAME = "thing";
    public static final String THING_ID = "thingId";

    @DynamoDBHashKey(attributeName = THING_ID)
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.N)
    private Long thingId;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private String title;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.BOOL)
    private Boolean isAbstract;

    @DynamoDBIgnore
    private Set<Thing> childThings;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.N)
    private Long parentId;

    @DynamoDBIgnore
    private Thing parentThing;

    @DynamoDBIgnore
    private Set<CustomSetThing> customSetThings = new HashSet<>();

    @DynamoDBIgnore
    private Set<Compares> compares = new HashSet<>();

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.M)
    public Map<String, Descriptor> Descriptors;
}
