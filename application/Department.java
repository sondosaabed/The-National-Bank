package application;

/* 
    Department object
*/

public class Department {
    private int departmentID;
    private String departmentName;
    private int departmentPhone;
    private String departmentEmail;
    private int BranchId;
    private int managerID;

    public Department() {
        super();
    }

    public Department(int departmentID, String departmentName, int departmentPhone, String departmentEmail, int branchId, int managerID) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.departmentPhone = departmentPhone;
        this.departmentEmail = departmentEmail;
        BranchId = branchId;
        this.managerID = managerID;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentPhone() {
        return departmentPhone;
    }

    public void setDepartmentPhone(int departmentPhone) {
        this.departmentPhone = departmentPhone;
    }

    public String getDepartmentEmail() {
        return departmentEmail;
    }

    public void setDepartmentEmail(String departmentEmail) {
        this.departmentEmail = departmentEmail;
    }

    public int getBranchId() {
        return BranchId;
    }

    public void setBranchId(int branchId) {
        BranchId = branchId;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }
}
