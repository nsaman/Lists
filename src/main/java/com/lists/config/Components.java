package com.lists.config;

import com.lists.handler.CreateElaticIndexesHandler;
import com.lists.handler.DynamoThingStreamHandler;
import dagger.Component;

import javax.inject.Singleton;

@Component(modules = {
        Module.class
})
@Singleton
public interface Components {

    DynamoThingStreamHandler dynamoThingStreamHandler();

    CreateElaticIndexesHandler createElaticIndexesHandler();
}
