package Sample;

/**
 * Card Table
 */

import java.util.Date;

public class Card {
    private int creditID;
    private double limit;
    private Date expDate;
    private int customerId;
    public Card() {
        super();
    }

    public Card(double limit, Date expDate, int customerId) {
        this.limit = limit;
        this.expDate = expDate;
        this.customerId = customerId;
    }

    public Card(int creditID, double limit, Date expDate, int customerId) {
        this.creditID = creditID;
        this.limit = limit;
        this.expDate = expDate;
        this.customerId = customerId;
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

}
