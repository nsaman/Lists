package com.lists.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import lombok.Data;

/**
 * Created by nick on 10/9/2018.
 */
@Data
public abstract class AuditedEntity {
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private String createUserID;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private String changeUserID;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.N)
    private Long createTimestamp;
}