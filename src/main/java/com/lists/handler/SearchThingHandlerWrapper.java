package com.lists.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.lists.config.Components;
import com.lists.config.DaggerComponents;

import java.util.List;
import java.util.Map;

public class SearchThingHandlerWrapper implements RequestHandler<Map<String, Object>, List<String>> {

    SearchThingHandler searchThingHandler;

    public SearchThingHandlerWrapper() {
        final Components components = DaggerComponents.builder().build();
        searchThingHandler = components.searchThingHandler();
    }

    public List<String> handleRequest(Map<String, Object> params, final Context context) {
        return searchThingHandler.handleRequest(params, context);
    }

}
