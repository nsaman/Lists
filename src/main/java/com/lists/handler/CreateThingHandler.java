package com.lists.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lists.dao.ThingDao;
import com.lists.model.Thing;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;

@Slf4j
public class CreateThingHandler implements RequestHandler<Thing, Void> {

    final private ThingDao thingDao;

    @Inject
    public CreateThingHandler(ThingDao thingDao) {
        this.thingDao = thingDao;
    }

    public Void handleRequest(Thing thing, final Context context) {

        thingDao.save(thing);

        return null;
    }
}
