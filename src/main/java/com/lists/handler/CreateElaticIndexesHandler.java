package com.lists.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.lists.model.Thing;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Handler for requests to Lambda function.
 */
@Slf4j
public class CreateElaticIndexesHandler implements RequestHandler<DynamodbEvent, Void> {
    private static final String ELASTIC_SEARCH_NAME = "es";

    private RestHighLevelClient restHighLevelClient;

    @Inject
    public CreateElaticIndexesHandler(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    public Void handleRequest(DynamodbEvent ddbEvent, final Context context) {

        try {
            restHighLevelClient.indices().create(new CreateIndexRequest(Thing.TABLE_NAME), RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("failed to create indexes", e);
        }

        return null;
    }
}
