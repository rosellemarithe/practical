package com.grocery.information.management.data.dao.grocery.items;

import com.grocery.information.management.appl.model.items.Items;

import java.util.List;

/**
 * Interface for Item Data Access Object.
 * */
public interface ItemsDao {

    List<Items> getAllItems();


    Items getItemsById(String id);


    List<Items> getItemsByIdList(List<String> ids);

    boolean addItems(Items items);
}