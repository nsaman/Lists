package com.lists.dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.lists.model.AuditedEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseDao<T extends AuditedEntity> {

    protected String tableName;
    protected DynamoDBMapper dynamoDBMapper;

    public void save(T entry) {
        dynamoDBMapper.save(entry);
    }
}
