package com.grupo6.bill_ms.models;

import org.springframework.data.annotation.Id;
public class Bill_Pro {
    @Id
    private final Integer id;
    private Integer amount;
    private Integer sub_total;
    public Bill_Pro(Integer id, Integer amount, Integer sub_total) {
        this.id = id;
        this.amount = amount;
        this.sub_total = sub_total;
    }
    //faltan las fk bill_id y product_id
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