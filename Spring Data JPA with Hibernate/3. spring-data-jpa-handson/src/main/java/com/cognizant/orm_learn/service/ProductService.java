package com.cognizant.orm_learn.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.model.ProductSearchCriteria;
import com.cognizant.orm_learn.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<Product> searchProducts(ProductSearchCriteria criteria) {
        return productRepository.searchProducts(criteria);
    }
}
