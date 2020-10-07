package com.lists.dao;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.lists.model.Thing;

public class ThingDao extends BaseDao<Thing> {

    public ThingDao(AmazonDynamoDB amazonDynamoDB) {
        this.tableName = Thing.TABLE_NAME;
        this.dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

}
