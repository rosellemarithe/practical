package com.grocery.information.management.data.utils;

public final class QueryConstants {
    private QueryConstants() {
    }

    //Customer DAO constants
    public static final String GET_ALL_CUSTOMERS_STATEMENT = "SELECT * FROM CUSTOMERS";
    public static final String GET_CUSTOMERS_BY_ID_STATEMENT = "SELECT * FROM CUSTOMERS WHERE ID = ?";


    //Item DAO constants
    public static final String GET_ALL_ITEMS_STATEMENT = "SELECT * FROM ITEMS";
    public static final String GET_ITEM_BY_ID_STATEMENT = "SELECT * FROM ITEMS WHERE id = ?";

    public static final String ADD_ITEMS_STATEMENT = "INSERT INTO ITEM VALUES (?, ?, ?, ?)";
    public static final String GET_ITEMS_BY_IDS_STATEMENT = "SELECT * FROM items " +
            "WHERE id IN";


    //Transaction DAO constants
    public static final String GET_TRANSACTION_ITEMS_COUNT = "SELECT * FROM TABLE(GET_ITEM_COUNT())";
}
