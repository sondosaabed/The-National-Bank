package Sample;

import java.util.Date;

/* 
    Employee object
*/

public class Employee {
    private int employeeID;
    private String employeeName;
    private int employeePhone;
    private String employeeGender;
    private Date employeeDOB;
    private String employeeEmail;
    private double employeeSalary;
    private int departmentID;
    private int address;
    public Employee() {
        super();
    }
    public Employee(String employeeName, int employeePhone, String employeeGender, Date employeeDOB, String employeeEmail, double employeeSalary, int departmentID, int address) {
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeGender = employeeGender;
        this.employeeDOB = employeeDOB;
        this.employeeEmail = employeeEmail;
        this.employeeSalary = employeeSalary;
        this.departmentID = departmentID;
        this.address = address;
    }
    public Employee(int employeeID, String employeeName, int employeePhone, String employeeGender, Date employeeDOB, String employeeEmail, double employeeSalary, int departmentID, int address) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.employeeGender = employeeGender;
        this.employeeDOB = employeeDOB;
        this.employeeEmail = employeeEmail;
        this.employeeSalary = employeeSalary;
        this.departmentID = departmentID;
        this.address = address;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(int employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public Date getEmployeeDOB() {
        return employeeDOB;
    }

    public void setEmployeeDOB(Date employeeDOB) {
        this.employeeDOB = employeeDOB;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}