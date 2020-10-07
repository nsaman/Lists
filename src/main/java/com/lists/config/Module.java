package com.lists.config;

import com.amazonaws.PredefinedClientConfigurations;
import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.google.gson.Gson;
import com.lists.dao.ThingDao;
import dagger.Provides;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import javax.inject.Named;
import javax.inject.Singleton;

@dagger.Module
public class Module {
    private static final String ELASTIC_SEARCH_NAME = "es";

    public static final String ELASTIC_ENDPOINT = "elasticEndpoint";
    @Provides
    @Singleton
    @Named(ELASTIC_ENDPOINT)
    String elasticEndpoint() {
        return System.getenv(ELASTIC_ENDPOINT);
    }

    public static final String AWS_REGION = "AWS_REGION";
    @Provides
    @Singleton
    String awsRegion() {
        return System.getenv(AWS_REGION);
    }

    @Provides
    @Singleton
    AWS4Signer signer() {
        AWS4Signer signer = new AWS4Signer();
        signer.setServiceName(ELASTIC_SEARCH_NAME);
        signer.setRegionName(awsRegion());

        return signer;
    }

    @Provides
    @Singleton
    HttpRequestInterceptor interceptor(AWS4Signer signer) {
        return new AWSRequestSigningApacheInterceptor(ELASTIC_SEARCH_NAME, signer, new DefaultAWSCredentialsProviderChain());
    }

    @Provides
    @Singleton
    RestHighLevelClient restHighLevelClient(HttpRequestInterceptor interceptor) {
        return new RestHighLevelClient(RestClient.builder(HttpHost.create(elasticEndpoint())).setHttpClientConfigCallback(hacb -> hacb.addInterceptorLast(interceptor)));
    }

    @Provides
    @Singleton
    Gson gson() {
        return new Gson();
    }

    @Provides
    @Singleton
    AmazonDynamoDB amazonDynamoDB() {
        return AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(awsRegion())
                .withClientConfiguration(PredefinedClientConfigurations.dynamoDefault())
                .build();
    }

    @Provides
    @Singleton
    ThingDao thingDao() {
        return new ThingDao(amazonDynamoDB());
    }

}
