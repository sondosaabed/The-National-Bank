package Sample;

import java.sql.Date;

/* 
    This class is used to make a transaction object
*/

public class Transaction {
    private int transactionID;
    private Date transpositionDate;
    private String transpositionType;
    private double transpositionAmount;
    private int employeeID;
    private int customer_id;

    public Transaction() {
        super();
    }
    public Transaction(Date transpositionDate, String transpositionType, double transpositionAmount, int employeeID, int customer_id) {
        this.transpositionDate = transpositionDate;
        this.transpositionType = transpositionType;
        this.transpositionAmount = transpositionAmount;
        this.employeeID = employeeID;
        this.customer_id = customer_id;
    }
    public Transaction(int transactionID, Date transpositionDate, String transpositionType, double transpositionAmount, int employeeID, int customer_id) {
        this.transactionID = transactionID;
        this.transpositionDate = transpositionDate;
        this.transpositionType = transpositionType;
        this.transpositionAmount = transpositionAmount;
        this.employeeID = employeeID;
        this.customer_id = customer_id;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public Date getTranspositionDate() {
        return transpositionDate;
    }

    public void setTranspositionDate(Date transpositionDate) {
        this.transpositionDate = transpositionDate;
    }

    public String getTranspositionType() {
        return transpositionType;
    }

    public void setTranspositionType(String transpositionType) {
        this.transpositionType = transpositionType;
    }

    public double getTranspositionAmount() {
        return transpositionAmount;
    }

    public void setTranspositionAmount(double transpositionAmount) {
        this.transpositionAmount = transpositionAmount;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
