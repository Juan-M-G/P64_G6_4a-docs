package com.grupo6.bill_ms.models;
import org.springframework.data.annotation.Id;
import java.util.Date;
public class Bill {
    @Id
    private final Integer id;
    private String clientName;
    private Date billDate;
    private Boolean isActive;
    //campo para user pk

    public Bill(Integer id, String clientName, Boolean isActive, Date billDate) {
        this.id = id;
        this.clientName = clientName;
        this.isActive = isActive;
        this.billDate = billDate;
    }

    public Integer getId() {
        return id;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
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