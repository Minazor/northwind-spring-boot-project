package com.example.FinalProject.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;




//Serileştirme işlemi sayesinde dosyadaki verilerin tipleri korunur

//@Data
//@Entity
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="customer_id")
    private String customerId;
    
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
