package application;

import java.util.Date;

/* 
   Loan Object
*/

public class Loan {
    private int loanNumber;
    private double amount;
    private String type;
    int branchId;
    private int customerId;
    private Date loanDate;
    public Loan() {
        super();
    }

    public Loan(double amount, String type, int branchId, int customerId, Date loanDate) {
        this.amount = amount;
        this.type = type;
        this.branchId = branchId;
        this.customerId = customerId;
        this.loanDate = loanDate;
    }

    public Loan(int loanNumber, double amount, String type, int branchId, int customerId, Date loanDate) {
        this.loanNumber = loanNumber;
        this.amount = amount;
        this.type = type;
        this.branchId = branchId;
        this.customerId = customerId;
        this.loanDate = loanDate;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getLoanNumber() {
        return loanNumber;
    }
    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Date getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

}
