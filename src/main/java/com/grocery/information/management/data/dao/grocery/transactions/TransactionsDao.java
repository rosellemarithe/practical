package com.grocery.information.management.data.dao.grocery.transactions;

import com.grocery.information.management.appl.model.items.Items;
import com.grocery.information.management.appl.model.transactions.Transactions;

import java.util.List;

public interface TransactionsDao {
    Transactions getTransactionsByID(int id);

    List<Transactions> getAllTransactions();

    Transactions getTransactionsById(String id);

    List<Transactions> getTransactionsByIdList(List<String> ids);
}
