package com.grocery.information.management.appl.facade.grocery.items.impl;

import com.grocery.information.management.appl.facade.grocery.items.ItemsFacade;
import com.grocery.information.management.appl.model.items.Items;
import com.grocery.information.management.data.dao.grocery.items.ItemsDao;
import com.grocery.information.management.data.dao.grocery.items.impl.ItemsDaoImpl;

import java.util.List;

public class ItemsFacadeImpl implements ItemsFacade {
    private ItemsDao itemsDao = new ItemsDaoImpl();

    @Override
    public List<Items> getAllItems() {
        return itemsDao.getAllItems();
    }

    @Override
    public Items getItemById(String id) {
        return itemsDao.getItemsById(id);
    }

    @Override
    public List<Items> getItemsByIdList(List<String> ids) {
        return itemsDao.getItemsByIdList(ids);
    }

    @Override
    public boolean addItem(Items items) throws ItemsExistsException {
        boolean result = false;
        Items targetItems = getItemsById(items.getId());
        if(targetItems != null) {
            throw new ItemExistsException("Item to add already exists. ");
        }
        result = itemsDao.addItems(items);
        return result;
    }
}