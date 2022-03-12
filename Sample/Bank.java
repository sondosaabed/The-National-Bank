package Sample;
/* 
    Bank Object 
*/
public class Bank {
    private String name;
    private int BID;

    public Bank() {
        super();
    }
    public Bank(String name, int bID) {
        super();
        this.name = name;
        BID = bID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getBID() {
        return BID;
    }
    public void setBID(int bID) {
        BID = bID;
    }
}