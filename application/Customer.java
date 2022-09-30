package application;

import java.sql.Date;
/* 
    Customer table/ object
*/

public class Customer {
    private int customerID;
    private String customerName;
    private int customerPhone;
    private Date DOB ;
    private String gender;
    private int address;

    public Customer(String customerName, int customerPhone, Date DOB, String gender, int address) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
    }

    public Customer(int customerID, String customerName, int customerPhone, Date DOB, String gender, int address) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
    }

    public Customer(int id) {
        this.customerID=id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int cID) {
        customerID = cID;
    }
    public String getName() {
        return customerName;
    }
    public void setName(String name) {
        this.customerName = name;
    }
    public int getAddress() {
        return address;
    }
    public void setAddress(int address) {
        this.address = address;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public Date getDOB() {
        return DOB;
    }
    public void setDOB(Date dOB) {
        DOB = dOB;
    }
}
