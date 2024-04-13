package com.grocery.information.management.appl.model.items;

public class Items {
    private String id;
    private String description;
    private int unit_price;
    private int qty;

    public Items() {
    }


    public Items(String id, String description, int unit_price, int qty) {
        this.id = id;
        this.description = description;
        this.unit_price = unit_price;
        this.qty = qty;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
