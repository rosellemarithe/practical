package com.grocery.information.management.data.dao.grocery.customers.impl;

import com.grocery.information.management.appl.model.customers.Customers;
import com.grocery.information.management.data.connectionhelper.ConnectionHelper;
import com.grocery.information.management.data.dao.grocery.customers.CustomersDao;
import com.grocery.information.management.data.dao.grocery.items.impl.ItemsDaoImpl;
import com.grocery.information.management.data.utils.QueryConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomersDaoImpl implements CustomersDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsDaoImpl.class);


    @Override
    public List<Customers> getAllCustomers() {
        List<Customers> customersList = new ArrayList<>();
        try (Connection con = new ConnectionHelper().getConnection()){
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ALL_ITEMS_STATEMENT);
            ResultSet rs= statement.executeQuery();

            while(rs.next()) {
                customersList.add(setCustomers(rs));
            }
            LOGGER.debug("Items retrieved successfully.");

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Items database is empty.");
        return customersList;
    }

    @Override
    public Customers getCustomersById() {
        Customers customers = null;
        private String id;
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_CUSTOMERS_BY_ID_STATEMENT);
            statement.setInt(1, Integer.parseInt(id));

            ResultSet rs= statement.executeQuery();

            if(rs.next()) {
                LOGGER.debug("Item retrieved successfully.");
                customers = setCustomers(rs);
            }

        } catch (Exception ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Item not found.");
        return customers;
    }

    private Customers setCustomers(ResultSet rs) {
        try {
            Customers customers = new Customers();
            customers.setId(rs.getString("customer_id"));
            customers.setName(rs.getString("name"));
            customers.setAddress(rs.getString("address"));
            customers.setContactNumber(String.valueOf(Integer.parseInt(rs.getString("qty"))));
            return customers;
        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("No customer was set.");
        return null;
    }

}

