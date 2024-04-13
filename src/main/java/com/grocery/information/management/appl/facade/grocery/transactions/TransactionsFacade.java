package com.grocery.information.management.appl.facade.grocery.transactions;

import com.grocery.information.management.appl.model.items.Items;
import com.grocery.information.management.appl.model.transactions.Transactions;

import java.util.List;

public interface TransactionsFacade {
    List<Transactions> getAllItems();

    Transactions getTransactionsById(String id);

    List<Transactions> getTransactionsByIdList(List<String> ids);
    boolean addTransactions(Transactions transactions) throws ItemsExistsException;

}
