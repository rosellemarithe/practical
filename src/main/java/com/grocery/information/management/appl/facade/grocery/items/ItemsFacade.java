package com.grocery.information.management.appl.facade.grocery.items;

import com.grocery.information.management.appl.model.items.Items;

import java.util.List;

public interface ItemsFacade {
    List<Items> getAllItems();

    Items getItemsById(String id);

    Items getItemById(String id);

    List<Items> getItemsByIdList(List<String> ids);
    boolean addItem(Items items) throws ItemsExistsException;
}
