package com.grupo6.bill_ms.models;

import org.springframework.data.annotation.Id;
public class Bill_Pro {
    @Id
    private Integer id;
    private Integer amount;
    private Integer sub_total;
    private Integer billId;
    private Integer productId;
    //Agregué las fk bill_id y product_id


    public Bill_Pro(Integer id, Integer amount, Integer sub_total, Integer billId,Integer productId) {
        this.id = id;
        this.amount = amount;
        this.sub_total = sub_total;
        this.billId = billId;
        this.productId = productId;

    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getBillId() {
        return billId;
    }
    public void setBillId(Integer billId) {
        this.billId = billId;
    }
    public Integer getId() {
        return id;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getSub_total() {
        return sub_total;
    }
    public void setSub_total(Integer sub_total) {
        this.sub_total = sub_total;
    }
}