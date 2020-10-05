package com.lists.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.lists.config.Components;
import com.lists.config.DaggerComponents;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Handler for requests to Lambda function.
 */
@Slf4j
@AllArgsConstructor
public class CreateElaticIndexesHandlerWrapper implements RequestHandler<DynamodbEvent, Void> {

    CreateElaticIndexesHandler createElaticIndexesHandler;

    public CreateElaticIndexesHandlerWrapper() {
        final Components components = DaggerComponents.builder().build();
        createElaticIndexesHandler = components.createElaticIndexesHandler();
    }

    public Void handleRequest(DynamodbEvent ddbEvent, final Context context) {
        return createElaticIndexesHandler.handleRequest(ddbEvent, context);
    }
}
