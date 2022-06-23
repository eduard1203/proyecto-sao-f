package com.curso.ecommerce.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.curso.ecommerce.model.Product;
@Repository("ProductRepository")
public interface ProductRepository extends CrudRepository<Product, String>{

}