package application;
/* 
    Branch Object 
*/
public class Branch {
    private int branchId;
    private String branchName;
    private String email;
    private int branchPhone;
    private int bankId;
    private int addressId;

    public Branch() {
        super();
    }

    public Branch(int branchId, String branchName, String email, int branchPhone, int bankId, int addressId) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.email = email;
        this.branchPhone = branchPhone;
        this.bankId = bankId;
        this.addressId = addressId;
    }

    public Branch(int id) {
        this.branchId =id;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(int branchPhone) {
        this.branchPhone = branchPhone;
    }

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
