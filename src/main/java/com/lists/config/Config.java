package com.lists.config;

import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    private static final String ELASTIC_SEARCH_NAME = "es";

    @Value("${elasticEndpoint}")
    private String elasticEndpoint;

    @Value("${AWS_REGION}")
    private String region;

    @Bean
    public DefaultAWSCredentialsProviderChain defaultAWSCredentialsProviderChain() {
        return new DefaultAWSCredentialsProviderChain();
    }

    @Bean
    public RestHighLevelClient restHighLevelClient(DefaultAWSCredentialsProviderChain defaultAWSCredentialsProviderChain) {
        AWS4Signer signer = new AWS4Signer();
        signer.setServiceName(ELASTIC_SEARCH_NAME);
        signer.setRegionName(region);
        HttpRequestInterceptor interceptor = new AWSRequestSigningApacheInterceptor(ELASTIC_SEARCH_NAME, signer, defaultAWSCredentialsProviderChain);
        return new RestHighLevelClient(RestClient.builder(HttpHost.create(elasticEndpoint)).setHttpClientConfigCallback(hacb -> hacb.addInterceptorLast(interceptor)));
    }
}
