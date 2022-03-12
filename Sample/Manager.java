package Sample;

import java.util.Date;

/* 
    This class is for manager object
*/

public class Manager {
    private int managerId;
    private String manageName;
    private int managerPhone;
    private Date managerBOB;
    private String gender;
    private String email;
    private double salary;
    private int address;
    public Manager() {
        super();
    }

    public Manager(String manageName, int managerPhone, Date managerBOB, String gender, String email, double salary ,int address) {
        this.manageName = manageName;
        this.managerPhone = managerPhone;
        this.managerBOB = managerBOB;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.address=address;
    }

    public Manager(int managerId, String manageName, int managerPhone, Date managerBOB, String gender, String email, double salary ,int address) {
        this.managerId = managerId;
        this.manageName = manageName;
        this.managerPhone = managerPhone;
        this.managerBOB = managerBOB;
        this.gender = gender;
        this.email = email;
        this.salary = salary;
        this.address=address;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getManageName() {
        return manageName;
    }

    public void setManageName(String manageName) {
        this.manageName = manageName;
    }

    public int getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(int managerPhone) {
        this.managerPhone = managerPhone;
    }

    public Date getManagerBOB() {
        return managerBOB;
    }

    public void setManagerBOB(Date managerBOB) {
        this.managerBOB = managerBOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}