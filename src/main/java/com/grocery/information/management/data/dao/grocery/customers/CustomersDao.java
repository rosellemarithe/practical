package com.grocery.information.management.data.dao.grocery.customers;

import com.grocery.information.management.appl.model.customers.Customers;

import java.util.List;

public interface CustomersDao {
    List<Customers> getAllCustomers();


    Customers getCustomersById();


}

