package com.lists.handler;

import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.models.dynamodb.AttributeValue;
import com.amazonaws.services.lambda.runtime.events.models.dynamodb.OperationType;
import com.amazonaws.services.lambda.runtime.events.models.dynamodb.StreamRecord;
import com.google.gson.Gson;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class DynamoThingStreamHandlerTest {

    @Mock
    private RestHighLevelClient restHighLevelClient;

    DynamoThingStreamHandler dynamoThingStreamHandler;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        Gson gson = new Gson();
        dynamoThingStreamHandler = new DynamoThingStreamHandler(restHighLevelClient, gson);
    }

    @Test
    public void getBulkRequest() {
        DynamodbEvent.DynamodbStreamRecord record = new DynamodbEvent.DynamodbStreamRecord();
        record.setDynamodb(new StreamRecord());
        record.setEventName(OperationType.INSERT);

        Map<String, AttributeValue> newImage = new HashMap<>();
        newImage.put("thingId", new AttributeValue().withN("1"));
        newImage.put("changeTimestamp", new AttributeValue().withN(String.valueOf(Instant.now().getEpochSecond())));

        record.getDynamodb().setNewImage(newImage);
        DynamodbEvent input = new DynamodbEvent();
        input.setRecords(Collections.singletonList(record));

        dynamoThingStreamHandler.getBulkRequest(input);
    }
}