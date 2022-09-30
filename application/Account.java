package application;
import java.util.Date;

/**
 * Account Table
 */

public class Account {
    private int accountId;
    private int customerId;
    private String accountType;
    private Date registrationDate;
    private Date activationDate;
    private int branchID;
    private double interest;
    private double initialDeposit;

    public Account(int id) {
        this.accountId=id;
    }
    
    public Account() {
    }

    public Account(int customerId, String accountType, Date registrationDate, Date activationDate, int branchID, double interest, double initialDeposit) {
        this.customerId = customerId;
        this.accountType = accountType;
        this.registrationDate = registrationDate;
        this.activationDate = activationDate;
        this.branchID = branchID;
        this.interest = interest;
        this.initialDeposit = initialDeposit;
    }


    public Account(int accountId, int customerId, String accountType, Date registrationDate, Date activationDate, int branchID, double interest, double initialDeposit) {
        this.accountId = accountId;
        this.customerId = customerId;
        this.accountType = accountType;
        this.registrationDate = registrationDate;
        this.activationDate = activationDate;
        this.branchID = branchID;
        this.interest = interest;
        this.initialDeposit = initialDeposit;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public int getBranchID() {
        return branchID;
    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getInitialDeposit() {
        return initialDeposit;
    }

    public void setInitialDeposit(double initialDeposit) {
        this.initialDeposit = initialDeposit;
    }
}
