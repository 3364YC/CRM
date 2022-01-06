package com.example.crm.entity;

public class Orders {
    private  int ordersId;
    private  int customerId;
    private  String goods;
    private  String amount;
    private  String ordersDate;
    @Override
    public String toString() {
        return "Orders{" +
                "ordersId=" + ordersId +
                ", customersId=" + customerId +
                ", goods='" + goods + '\'' +
                ", amount='" + amount + '\'' +
                ", ordersDate='" + ordersDate + '\'' +
                '}';
    }

    public int getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(int ordersId) {
        this.ordersId = ordersId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate;
    }


}
