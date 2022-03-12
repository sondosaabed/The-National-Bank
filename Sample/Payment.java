package Sample;

import java.util.Date;

/* 
    This class is for payment object
*/

public class Payment {
    private int paymentNumber;
    private double paymentAmount;
    private Date paymentDate;
    private int loanNumber;

    public Payment() {
        super();
    }
    public Payment(double paymentAmount, Date paymentDate, int loanNumber) {
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.loanNumber = loanNumber;
    }

    public Payment(int paymentNumber, double paymentAmount, Date paymentDate, int loanNumber) {
        this.paymentNumber = paymentNumber;
        this.paymentAmount = paymentAmount;
        this.paymentDate = paymentDate;
        this.loanNumber = loanNumber;
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }
}