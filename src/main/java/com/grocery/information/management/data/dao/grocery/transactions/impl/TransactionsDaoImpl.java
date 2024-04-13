package com.grocery.information.management.data.dao.grocery.transactions.impl;

import com.grocery.information.management.appl.model.transactions.Transactions;
import com.grocery.information.management.data.connectionhelper.ConnectionHelper;
import com.grocery.information.management.data.dao.grocery.transactions.TransactionsDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDaoImpl implements TransactionsDao{
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsDaoImpl.class);

    @Override
    public Transactions getTransactionsByID(int id) {
        try (Connection con =  ConnectionHelper.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int transactionNum = rs.getInt("transaction_num");
                    int itemId = rs.getInt("item_id");
                    String customerId = rs.getString("customer_id");
                    Timestamp transaction_date = rs.getTimestamp("transaction_date");
                    return new Transactions();
                } else {
                    LOGGER.warn("No offense found with ID: " + id);
                }
            }
        } catch (Exception ex) {
            LOGGER.warn("Error retrieving offense with ID " + id + ": " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense not found.");
        return null;
    }




    @Override
    public List<Transactions> getAllTransactions() {
        List<Transactions> transactions = new ArrayList<>();
        String sql = "SELECT * FROM offense";
        try (Connection con = ConnectionHelper.getConnection();
             PreparedStatement statement = con.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Transactions transactions = new Transactions();
                transactions.setId(resultSet.getInt("id"));
                transactions.setViolationId(resultSet.getInt("violation_id"));
                transactions.setStudentId(resultSet.getString("student_id"));
                transactions.setOffenseDate(resultSet.getTimestamp("offense_date"));
                transactions.add(offense);
            }
            LOGGER.info("Offenses retrieved successfully.");
        } catch (Exception ex) {
            LOGGER.warn("Error retrieving all offenses: " + ex.getMessage());
            ex.printStackTrace();
        }
        LOGGER.debug("Offense database is empty.");
        return transactions;

    }

    @Override
    public Transactions getTransactionsById(String id) {
        return null;
    }

    @Override
    public List<Transactions> getTransactionsByIdList(List<String> ids) {
        return null;
    }
}

