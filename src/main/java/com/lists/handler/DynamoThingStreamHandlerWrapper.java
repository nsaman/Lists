package com.lists.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.lists.config.Components;
import com.lists.config.DaggerComponents;

public class DynamoThingStreamHandlerWrapper implements RequestHandler<DynamodbEvent, Void> {

    DynamoThingStreamHandler dynamoThingStreamHandler;

    public DynamoThingStreamHandlerWrapper() {
        final Components components = DaggerComponents.builder().build();
        dynamoThingStreamHandler = components.dynamoThingStreamHandler();
    }

    public Void handleRequest(DynamodbEvent ddbEvent, final Context context) {
        return dynamoThingStreamHandler.handleRequest(ddbEvent, context);
    }

}
