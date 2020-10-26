package com.lists.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.lists.model.Thing;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import javax.inject.Inject;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SearchThingHandler implements RequestHandler<Map<String, Object>, List<String>> {

    public static final String START_AT = "startAt";
    public static final String PAGE_SIZE = "pageSize";
    public static final String ORDER = "order";
    public static final String ORDER_KEY = "orderKey";

    private RestHighLevelClient restHighLevelClient;

    @Inject
    public SearchThingHandler(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    public List<String> handleRequest(Map<String, Object> params, final Context context) {

        Map<String, Object> copy = new HashMap<>(params);

        SearchRequest searchRequest = new SearchRequest(Thing.TABLE_NAME);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        if(copy.containsKey(START_AT)) {
            searchSourceBuilder.from((int)copy.get(START_AT));
            copy.remove(START_AT);
        }
        if(copy.containsKey(PAGE_SIZE)) {
            searchSourceBuilder.size((int)copy.get(PAGE_SIZE));
            copy.remove(PAGE_SIZE);
        }

        if(copy.containsKey(ORDER_KEY) && copy.containsKey(ORDER)) {
            FieldSortBuilder fieldSortBuilder = new FieldSortBuilder((String)copy.get(ORDER_KEY));

            if (copy.get(ORDER).equals(SortOrder.ASC.name()))
                fieldSortBuilder.order(SortOrder.ASC);
            else
                fieldSortBuilder.order(SortOrder.DESC);
        }

        copy.forEach((key,value) ->
                searchSourceBuilder.query(QueryBuilders.termQuery(key, value))
                );

        searchSourceBuilder.timeout(new TimeValue(20, TimeUnit.SECONDS));

        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse;
        try {
            searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        } catch (IOException ioException) {
            log.error("Search failed with search map: {}", params.toString(), ioException);
            return null;
        }

        List<String> response = new ArrayList<>();
        searchResponse.getHits().forEach(hit -> response.add(hit.getSourceAsString()));

        return response;
    }
}
