package com.example.twotablehibernate.repository;

import com.example.twotablehibernate.entity.Customers;
import com.example.twotablehibernate.entity.Orders;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ProductRepository {

    @PersistenceContext
    EntityManager entityManager;


    public String getProductName(String name) {
        name = name.toLowerCase();

        List<?> orders = entityManager.createNativeQuery(
                        "select product_name from orders inner join customers on customer_id = customers.id where lower(name) = ?1", String.class)
                .setParameter(1, name)
                .getResultList();

        return orders.toString();
    }

    public void putDataCustomers(List<Customers> customers) {
        customers.forEach(entityManager::persist);
    }

    public void putDataOrders(List<Orders> orders) {
        orders.forEach(entityManager::persist);
    }

}
