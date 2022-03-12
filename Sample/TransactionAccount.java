package Sample;

/* 
    This class is used to make a Transaction-Account object used due to many-many relation
*/

public class TransactionAccount {
    private int transactionPK;
    private int accountId;
    private int transactionID;

    public TransactionAccount(int accountId, int transactionID) {
        this.accountId = accountId;
        this.transactionID = transactionID;
    }
    
    public int getTransactionPK() {
        return transactionPK;
    }

    public void setTransactionPK(int transactionPK) {
        this.transactionPK = transactionPK;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }
}
