package com.lists.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lists.model.Thing;

import java.util.List;

/**
 * Handler for requests to Lambda function.
 */
public class DynamoThingStreamHandler implements RequestHandler<List<Thing>, Void> {

    public Void handleRequest(final List<Thing> things, final Context context) {
        things.forEach(thing -> context.getLogger().log(thing.toString()));

        return null;
    }
}
