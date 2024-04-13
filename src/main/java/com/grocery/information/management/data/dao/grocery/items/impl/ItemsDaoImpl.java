package com.grocery.information.management.data.dao.grocery.items.impl;

import com.grocery.information.management.appl.model.items.Items;
import com.grocery.information.management.data.connectionhelper.ConnectionHelper;
import com.grocery.information.management.data.dao.grocery.items.ItemsDao;
import com.grocery.information.management.data.utils.QueryConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class ItemsDaoImpl implements ItemsDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsDaoImpl.class);

    @Override
    public List<Items> getAllItems() {
        List<Items> itemsList = new ArrayList<>();
        try (Connection con = new ConnectionHelper().getConnection()){
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ALL_ITEMS_STATEMENT);
            ResultSet rs= statement.executeQuery();

            while(rs.next()) {
                itemsList.add(setItems(rs));
            }
            LOGGER.debug("Items retrieved successfully.");

        } catch (Exception ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Items database is empty.");
        return itemsList;
    }

    @Override
    public Items getItemsById(String id) {
        Items item = null;
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ITEM_BY_ID_STATEMENT);
            statement.setString(1, id);
            ResultSet rs= statement.executeQuery();

            if(rs.next()) {
                LOGGER.debug("Item retrieved successfully.");
                item = setItems(rs);
            }

        } catch (Exception ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Item not found.");
        return item;
    }

    @Override
    public List<Items> getItemsByIdList(List<String> ids) {
        List<Items> itemsList = new ArrayList<>();
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ITEMS_BY_IDS_STATEMENT + buildParameters(ids));
            for(int i=1; i<=ids.size(); i++) {
                statement.setString(i, ids.get(i-1));
            }
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                itemsList.add(setItems(rs));
            }

        } catch (Exception ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        return itemsList;
    }
    private Items setItems(ResultSet rs) {
        try {
            Items items = new Items();
            items.setId(rs.getString("item_id"));
            items.setDescription(rs.getString("item_desc"));
            items.setUnit_price(Integer.parseInt(rs.getString("unit_price")));
            items.setQty(Integer.parseInt(rs.getString("qty")));
            return items;
        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("No item was set.");
        return null;
    }

    @Override
    public boolean addItems(Items items) {
        int result = 0;
        try (Connection con = new ConnectionHelper().getConnection()){
            PreparedStatement statement = con.prepareStatement(QueryConstants.ADD_ITEMS_STATEMENT);
            statement.setString(1, items.getId());
            statement.setString(2, items.getDescription());
            statement.setString(3, items.getUnit_price());
            statement.setInt(4, items.getQty());
            result = statement.executeUpdate();
            if(result == 1) {
                LOGGER.debug("Item successfully added.");
                return true;
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Adding item failed.");
        return false;
    }
    private String buildParameters(List<String> ids) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for(String id: ids) {
            sb.append("?, ");
        }

        //delete the last character added which is " "
        String params = sb.deleteCharAt(sb.length()-1).toString();

        //delete the second to the last character added which is ","
        params = sb.deleteCharAt(sb.length()-1).toString();
        params = params + ")";

        return params;
    }
}
