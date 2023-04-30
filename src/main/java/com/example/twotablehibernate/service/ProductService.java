package com.example.twotablehibernate.service;

import com.example.twotablehibernate.entity.Customers;
import com.example.twotablehibernate.entity.Orders;
import com.example.twotablehibernate.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public String getProducts(String name) {
        return repository.getProductName(name);
    }

    public String create() {

        List<Customers> customers = new ArrayList<>();

        Customers customer1 = Customers.builder()
                .name("Vladimir")
                .surname("Max")
                .age(35)
                .phoneNumber("89999998877").build();
        customers.add(customer1);

        Customers customer2 = Customers.builder()
                .name("Ola")
                .surname("Min")
                .age(28)
                .phoneNumber("89999998876").build();
        customers.add(customer2);

        Customers customer3 = Customers.builder()
                .name("Sabir")
                .surname("Bishop")
                .age(25)
                .phoneNumber("89999998875").build();
        customers.add(customer3);

        Customers customer4 = Customers.builder()
                .name("SABIR")
                .surname("Shop")
                .age(26)
                .phoneNumber("89999998874").build();
        customers.add(customer4);

        repository.putDataCustomers(customers);

        List<Orders> orders = new ArrayList<>();

        Orders order1 = Orders.builder()
                .customerId(customer1)
                .productName("стириальная машинка")
                .value(5000)
                .build();
        orders.add(order1);

        Orders order2 = Orders.builder()
                .customerId(customer2)
                .productName("пылесос")
                .value(2500)
                .build();
        orders.add(order2);

        Orders order3 = Orders.builder()
                .customerId(customer3)
                .productName("часы")
                .value(1500)
                .build();
        orders.add(order3);

        Orders order4 = Orders.builder()
                .customerId(customer4)
                .productName("машина")
                .value(150000)
                .build();
        orders.add(order4);

        repository.putDataOrders(orders);
        return "Success";
    }

}
