package com.grupo6.bill_ms.models;
import org.springframework.data.annotation.Id;
import java.util.Date;
public class Bill {
    @Id
    private Integer id;
    private String clientId;
    private Date billDate;
    private Boolean isActive;
    private Integer userId;//agregué este campo

    public Bill(Integer id, String clientId, Boolean isActive, Date billDate, Integer userId) {
        this.id = id;
        this.clientId = clientId;
        this.isActive = isActive;
        this.billDate = billDate;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }
    public Integer getUserId() {
        return userId;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public Boolean getIsActive() {
        return isActive;
    }
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    public Date getBillDate() {
        return billDate;
    }
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }
}