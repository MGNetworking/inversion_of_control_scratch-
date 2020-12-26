package com.project.myProduit.metierEntity;

public class Client {

    private String number;
    private String customerName;

    public Client(String customerName){
    this.setCustomerName(customerName);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
