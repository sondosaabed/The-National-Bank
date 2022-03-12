package SQL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Sample.TransactionAccount;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
/* 
    This class i
    s used to make a transaction-account query, due to many-many relation,
     including (insert, update)
*/
public class TransactionAccountQuery {
    DataBaseConnection connectionTOSQL = new DataBaseConnection();
    public ObservableList<TransactionAccount> dataList;
    public ArrayList<TransactionAccount> data = new ArrayList<>();
    
    private void getTransactionAccData() throws SQLException, ClassNotFoundException {
        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from transactions";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )
            data.add(new TransactionAccount(
                    Integer.parseInt(rs.getString(1)),
                    Integer.parseInt(rs.getString(2))));
        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
    }
    
    public void getData() throws SQLException, ClassNotFoundException {
        getTransactionAccData();
    }
    
	public void insertData(TransactionAccount rc) {
        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into transactions_accounts (account_id, Transaction_ID) values('"
            		+rc.getAccountId()+"',"
                    + rc.getTransactionID() +  ");");

            connectionTOSQL.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public boolean update(TransactionAccount transactionAccount,String sign) throws SQLException, ClassNotFoundException {
        double initialDeposit = 0;
        double amount = 0;
        
        String SQL = "select initial_deposity from accounts where account_id = " + transactionAccount.getAccountId() + ";";
        connectionTOSQL.connect();
        System.out.println("Connection established");
        System.out.println(SQL);
        
        Statement stmt = connectionTOSQL.getCon().createStatement();
        
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            initialDeposit = rs.getDouble("initial_deposity");
        }
        System.out.println(rs);

        String SQL1 = "select Transposition_amount from transactions where Transaction_ID = " + transactionAccount.getTransactionID() + ";";
        System.out.println(SQL1);
        
        ResultSet rs2 = stmt.executeQuery(SQL1);
        while (rs2.next()) {
            amount = rs2.getDouble("Transposition_amount");
        }
        System.out.println(rs2);
        
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed");
        
        if(sign.equalsIgnoreCase("-")) {
            if (initialDeposit == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText("You can't withdraw you have 0$");
                alert.showAndWait();
                return false;
            } else if (initialDeposit >= amount) {
                String SQL3;
                connectionTOSQL.connect();
                System.out.println("Connection established");
                SQL3 = "update Accounts set initial_deposity =" + "initial_deposity -" + amount + " where account_id =" + transactionAccount.getAccountId() + ";";
                System.out.println(SQL1);
                Statement stmt3 = connectionTOSQL.getCon().createStatement();
                stmt3.executeUpdate(SQL3);
                stmt3.close();
                connectionTOSQL.getCon().close();
                System.out.println("Connection closed");
                return true;
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Look, a Warning Dialog");
                alert.setContentText("Your account only have" + amount+ "$");
                alert.showAndWait();
            }
        }else {
            String SQL4;
            connectionTOSQL.connect();
            System.out.println("Connection established");
            SQL4 = "update Accounts set initial_deposity =" + "initial_deposity +" + amount + " where account_id =" + transactionAccount.getAccountId() + ";";
            System.out.println(SQL4);
            Statement stmt4 = connectionTOSQL.getCon().createStatement();
            stmt4.executeUpdate(SQL4);
            stmt4.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            return true;
        }
        return false;
    }
}
