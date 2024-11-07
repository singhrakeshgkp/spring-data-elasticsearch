package com.elasticsearchex.controller;

import com.elasticsearchex.model.Product;
import com.elasticsearchex.repo.ProductRepo;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

  @Autowired
  private ProductRepo productRepo;

  @PostMapping
  public Product create(@RequestBody Product Product) {
    return productRepo.save(Product);
  }
  @GetMapping("/{id}")
  public Optional<Product> findById(@PathVariable String id) {
    return productRepo.findById(id);
  }

  @GetMapping
  public Iterable<Product> findAll() {
    return productRepo.findAll();
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable String id, @RequestBody Product Product) {
    Product.setId(id);
    return productRepo.save(Product);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    productRepo.deleteById(id);
  }
}
