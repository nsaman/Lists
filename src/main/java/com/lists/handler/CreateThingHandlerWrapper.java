package com.lists.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lists.config.Components;
import com.lists.config.DaggerComponents;
import com.lists.model.Thing;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Handler for requests to Lambda function.
 */
@Slf4j
@AllArgsConstructor
public class CreateThingHandlerWrapper implements RequestHandler<Thing, Void> {

    CreateThingHandler createThingHandler;

    public CreateThingHandlerWrapper() {
        final Components components = DaggerComponents.builder().build();
        createThingHandler = components.createThingHandler();
    }

    public Void handleRequest(Thing thing, final Context context) {
        return createThingHandler.handleRequest(thing, context);
    }
}
