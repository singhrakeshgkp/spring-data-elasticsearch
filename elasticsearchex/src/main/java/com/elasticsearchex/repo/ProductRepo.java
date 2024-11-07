package com.elasticsearchex.repo;

import com.elasticsearchex.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepo extends ElasticsearchRepository<Product,String> {}
