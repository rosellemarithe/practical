package com.grocery.information.management.appl.facade.grocery.customers.impl;

import com.grocery.information.management.appl.facade.grocery.customers.CustomersFacade;
import com.grocery.information.management.appl.model.customers.Customers;
import com.grocery.information.management.appl.model.items.Items;
import com.grocery.information.management.data.dao.grocery.customers.CustomersDao;

import java.util.List;

public class CustomersFacadeImpl implements CustomersFacade {
    private CustomersDao customersDao;
    public CustomersFacadeImpl(CustomersDao customersDao) {
        this.customersDao = customersDao;
    }


    @Override
    public List<Customers> getAllCustomers() {
        return customersDao. getAllCustomers();
    }

    @Override
    public Customers getCustomersById(String id) {
        return customersDao. getCustomersById();
    }

    @Override
    public boolean getItemsByIdList(Customers customers) {
        return false;
    }
}
