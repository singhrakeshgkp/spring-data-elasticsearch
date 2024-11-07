package com.elasticsearchex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {

  @Override
  public ClientConfiguration clientConfiguration() {
    return ClientConfiguration.builder()
        .connectedTo("localhost:9200")
        .usingSsl("39a3ffc2d21338fc91ee0755db191a22fcf0b0d0c59f5ae8f07d0b881a3c0d16")
        .withBasicAuth("elastic","5uK=ZCHd*ztV63psU9Sm")
        .build();
    /*ssl, and basing auth such as user and password can be found in elastic server console*/
  }
}
