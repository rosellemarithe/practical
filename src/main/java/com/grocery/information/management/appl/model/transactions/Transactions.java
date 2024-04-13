package com.grocery.information.management.appl.model.transactions;

public class Transactions {
    private String transactionNum;
    private String itemId;
    private String customerId;
    private String transactionDate;

    public Transactions() {

    }



    public Transactions(String transactionNum, String itemId, String customerId, String transactionDate) {
        this.transactionNum = transactionNum;
        this.itemId = itemId;
        this.customerId = customerId;
        this.transactionDate =transactionDate;
    }
    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

}
