package com.grocery.information.management.appl.facade.grocery.customers;

import com.grocery.information.management.appl.model.customers.Customers;

import java.util.List;

public interface CustomersFacade {

    List<Customers> getAllCustomers();

    Customers getCustomersById(String id);

    boolean getItemsByIdList(Customers customers);

}

