package com.cognizant.orm_learn.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import com.cognizant.orm_learn.model.Product;
import com.cognizant.orm_learn.model.ProductSearchCriteria;

@Repository
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> searchProducts(ProductSearchCriteria criteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getBrand() != null && !criteria.getBrand().trim().isEmpty()) {
            predicates.add(cb.equal(cb.lower(product.get("brand")), criteria.getBrand().toLowerCase()));
        }

        if (criteria.getMaxPrice() != null) {
            predicates.add(cb.lessThanOrEqualTo(product.get("price"), criteria.getMaxPrice()));
        }

        if (criteria.getRamSize() != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("ramSize"), criteria.getRamSize()));
        }

        if (criteria.getOs() != null && !criteria.getOs().trim().isEmpty()) {
            predicates.add(cb.like(cb.lower(product.get("os")), "%" + criteria.getOs().toLowerCase() + "%"));
        }

        if (criteria.getMinRating() != null) {
            predicates.add(cb.greaterThanOrEqualTo(product.get("rating"), criteria.getMinRating()));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Product> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
