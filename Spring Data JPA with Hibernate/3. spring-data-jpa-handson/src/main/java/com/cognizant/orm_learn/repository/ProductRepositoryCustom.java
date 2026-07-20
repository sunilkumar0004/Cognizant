package com.cognizant.orm_learn.repository;

import java.util.List;
import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.model.ProductSearchCriteria;

public interface ProductRepositoryCustom {
    List<Product> searchProducts(ProductSearchCriteria criteria);
}
