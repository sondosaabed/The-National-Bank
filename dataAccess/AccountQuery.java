package dataAccess;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.choice;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.Account;

/*
    This class is used to make an account query including (delete, insert, update, search)
*/
public class AccountQuery {
    public ObservableList<Account> dataList;
    public ArrayList<Account> data = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();

    @SuppressWarnings("unchecked")
    public void tableView(Stage stage, GridPane pane) {
        TableView<Account> myDataTable = new TableView<Account>();

        Scene scene = new Scene(pane);
        stage.setTitle("Account Table");
        
        TableColumn<Account, Integer> id = new TableColumn<Account, Integer>("Number");
        id.setCellValueFactory(new PropertyValueFactory<Account, Integer>("accountId"));

        TableColumn<Account, Integer> customerID = new TableColumn<Account, Integer>("Customer ID");
        customerID.setCellValueFactory(new PropertyValueFactory<Account, Integer>("customerId"));

        TableColumn<Account, String> accountType = new TableColumn<Account, String>("Account Type");
        accountType.setCellValueFactory(new PropertyValueFactory<Account, String>("accountType"));

        TableColumn<Account,Date> regDate = new TableColumn<Account, Date>("Registration Date");
        regDate.setCellValueFactory(new PropertyValueFactory<Account, Date>("registrationDate"));

        TableColumn<Account, Date> activDate = new TableColumn<Account, Date>("Activation Date");
        activDate.setCellValueFactory(new PropertyValueFactory<Account, Date>("activationDate"));

        TableColumn<Account, Integer> branchID = new TableColumn<Account, Integer>("Branch ID");
        branchID.setCellValueFactory(new PropertyValueFactory<Account, Integer>("branchID"));

        TableColumn<Account, Double> interest = new TableColumn<Account, Double>("interest");
        interest.setCellValueFactory(new PropertyValueFactory<Account, Double>("interest"));

        TableColumn<Account, Double> initialDeposit = new TableColumn<Account, Double>("initial Deposit");
        initialDeposit.setCellValueFactory(new PropertyValueFactory<Account, Double>("initialDeposit"));

        myDataTable.setItems(dataList);
        myDataTable.getColumns().addAll(id, customerID ,accountType,regDate,activDate,branchID,interest,initialDeposit);
        Button close = new Button("Close");
        close.setFont(Font.font(14));
        close.setTextFill(Color.DARKSLATEBLUE);
        close.setPrefSize(90, 30);
        close.setStyle("-fx-background-radius: 10, 5;-fx-background-color:lightgrey;");
        close.setOnAction(k-> {
            data.clear();
            stage.close();
        });

        pane.add(myDataTable,1,1);
        pane.add(close,1,2);
        GridPane.setHalignment(close, HPos.CENTER);
        stage.setScene(scene);
    }

    private void getAccountData() throws SQLException, ClassNotFoundException {
        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from accounts";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )
            data.add(new Account(
                    Integer.parseInt(rs.getString(1)),
                    Integer.parseInt(rs.getString(2)),
                    rs.getString(3),
                    Date.valueOf(rs.getString(4)),
                    Date.valueOf(rs.getString(5)),
                    Integer.parseInt(rs.getString(6)),
                    Double.parseDouble(rs.getString(7)),
                    Double.parseDouble(rs.getString(8))));

        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
    }

    public void getData() throws SQLException, ClassNotFoundException {
        getAccountData();
    }

    public String delete(ArrayList<choice> conditions) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Delete from accounts Where ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Account_Type" || conditions.get(i).getType() == "Registration_Date" || conditions.get(i).getType() == "Activation_Date") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Account_Type" || conditions.get(i).getType() == "Registration_Date" || conditions.get(i).getType() == "Activation_Date") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans=    connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="accounts Deleted";
	            } else {
	                answer ="accounts not Deleted";
	            }
	            connectionTOSQL.getCon().close();
	            System.out.println("Connection closed");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
        }else{
            answer ="Nothing was found To Delete";
        }
        return answer;
    }

    public void insertData(Account rc) {
        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into accounts (customer_id, Account_Type, Registration_Date, Activation_Date, branch_ID, Interest, initial_deposity) values("
                   // + rc.getAccountId() +","
                    + rc.getCustomerId() +",'"
                    + rc.getAccountType() +"','"
                    + rc.getRegistrationDate() +"','"
                    + rc.getActivationDate() +"',"
                    + rc.getBranchID() +","
                    + rc.getInterest() +","
                    + rc.getInitialDeposit() +");");
            System.out.println();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed" + data.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public String update(ArrayList<choice> conditions, ArrayList<choice> choices) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Update accounts SET ";
	            connectionTOSQL.connect();
	            for(int i =0; i<choices.size();i++) {
	                if(i==choices.size()-1) {
	                    if (conditions.get(i).getType() == "Account_Type" || conditions.get(i).getType() == "Registration_Date" || conditions.get(i).getType() == "Activation_Date") {
	                        sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(choices.get(i).getType() + " = "  + choices.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Account_Type" || conditions.get(i).getType() == "Registration_Date" || conditions.get(i).getType() == "Activation_Date") {
	                    sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'" + ", ");
	                }else{
	                    sql= sql.concat(choices.get(i).getType() +" = " +choices.get(i).getValue()+ ", ");
	                }
	            }
	
	            sql = sql.concat(" Where ");
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Account_Type" || conditions.get(i).getType() == "Registration_Date" || conditions.get(i).getType() == "Activation_Date") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Account_Type" || conditions.get(i).getType() == "Registration_Date" || conditions.get(i).getType() == "Activation_Date") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="Accounts Updated";
	            } else {
	                answer ="Accounts not updated";
	            }
	            connectionTOSQL.getCon().close();
	            System.out.println("Connection closed");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
        }else{
            answer ="Nothing was found To Update";
        }
        return answer;
    }

	public String search(ArrayList<choice> conditions,ArrayList<choice> show, GridPane pane5, int i, int j) {
        ObservableList<Account> dataList = null ;
        TableView<Account> myDataTable = new TableView<Account>();
        ArrayList<Account> data = new ArrayList<>();
        
    	String answer="";
    	try {
            String sql="Select *";
            connectionTOSQL.connect();
            
    		for(int i2 =0; i2<show.size();i2++) {
	    		if(show.get(i2).getType() == "account_id") {
	    	        TableColumn<Account, Integer> id = new TableColumn<Account, Integer>("Number");
	    	        id.setCellValueFactory(new PropertyValueFactory<Account, Integer>("accountId"));
	    	        myDataTable.getColumns().add(id);
	    		} else if(show.get(i2).getType() == "customer_id") {
	    	        TableColumn<Account, Integer> customerID = new TableColumn<Account, Integer>("Customer ID");
	    	        customerID.setCellValueFactory(new PropertyValueFactory<Account, Integer>("customerId"));
	    			myDataTable.getColumns().add(customerID);
	    		}else if(show.get(i2).getType() == "Account_Type") {
	    	        TableColumn<Account, String> accountType = new TableColumn<Account, String>("Account Type");
	    	        accountType.setCellValueFactory(new PropertyValueFactory<Account, String>("accountType"));
	    	        myDataTable.getColumns().add(accountType);
	    		}else if(show.get(i2).getType() == "Registration_Date") {
	    	        TableColumn<Account,Date> regDate = new TableColumn<Account, Date>("Registration Date");
	    	        regDate.setCellValueFactory(new PropertyValueFactory<Account, Date>("registrationDate"));
	    	        myDataTable.getColumns().add(regDate);
	    		}else if(show.get(i2).getType() == "Activation_Date") {
	    			TableColumn<Account, Date> activDate = new TableColumn<Account, Date>("Activation Date");
	    	        activDate.setCellValueFactory(new PropertyValueFactory<Account, Date>("activationDate"));
	    	        myDataTable.getColumns().add(activDate);
	    		}else if(show.get(i2).getType() == "branch_ID") {
	    	        TableColumn<Account, Integer> branchID = new TableColumn<Account, Integer>("Branch ID");
	    	        branchID.setCellValueFactory(new PropertyValueFactory<Account, Integer>("branchID"));
	    	        myDataTable.getColumns().add(branchID);
	    		}else if(show.get(i2).getType() == "Interest") {
	    	        TableColumn<Account, Double> interest = new TableColumn<Account, Double>("interest");
	    	        interest.setCellValueFactory(new PropertyValueFactory<Account, Double>("interest"));
	    	        myDataTable.getColumns().add(interest);
	    		}else if(show.get(i2).getType() == "initial_deposity") {
	    	        TableColumn<Account, Double> initialDeposit = new TableColumn<Account, Double>("initial Deposit");
	    	        initialDeposit.setCellValueFactory(new PropertyValueFactory<Account, Double>("initialDeposit"));
	    	        myDataTable.getColumns().add(initialDeposit);
	    		}
	    	}
	    	sql= sql.concat(" From Accounts Where ");
    		for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Account_Type" || conditions.get(i1).getType() == "Registration_Date" || conditions.get(i1).getType() == "Activation_Date") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Account_Type" || conditions.get(i1).getType() == "Registration_Date" || conditions.get(i1).getType() == "Activation_Date") {
                    sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'" + " AND ");
                }else{
                    sql= sql.concat(conditions.get(i1).getType() +" = " +conditions.get(i1).getValue()+ " AND ");
                }
            }
	    	System.out.println(sql);
	    	
            Statement stmt = connectionTOSQL.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql+";");
            
            while (rs.next())
                data.add(
                		new Account(
                		        rs.getInt("account_id"),
                                rs.getInt("customer_id"),
                                rs.getString("Account_Type"),                                
                                rs.getDate("Registration_Date"),
                                rs.getDate("Activation_Date"),
                                rs.getInt("branch_ID"),
                                rs.getDouble("Interest"),
                                rs.getDouble("initial_deposity")
                				)		
                 );
            rs.close();
            stmt.close();
	        connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            
            dataList = FXCollections.observableArrayList(data);

	        myDataTable.setItems((ObservableList<Account>) dataList);
	    	
	        if(data.isEmpty()) {
	    		answer= "Nothing was found";
	    	} else {
	    		pane5.add(myDataTable,i,j);
	    		answer= "Found";
	    	}
            
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
    	return answer;
    }

    public String search(ArrayList<choice> conditions) {
        ObservableList<Account> dataList = null ;
        TableView<Account> myDataTable = new TableView<Account>();
        ArrayList<Account> data = new ArrayList<>();

        String answer="";
        try {
            String sql="Select *";
            connectionTOSQL.connect();
            sql= sql.concat(" From Accounts Where ");
            for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Account_Type" || conditions.get(i1).getType() == "Registration_Date" || conditions.get(i1).getType() == "Activation_Date") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Account_Type" || conditions.get(i1).getType() == "Registration_Date" || conditions.get(i1).getType() == "Activation_Date") {
                    sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'" + " AND ");
                }else{
                    sql= sql.concat(conditions.get(i1).getType() +" = " +conditions.get(i1).getValue()+ " AND ");
                }
            }
            System.out.println(sql);

            Statement stmt = connectionTOSQL.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql+";");

            while (rs.next())
                data.add(
                        new Account(
                                rs.getInt("account_id"),
                                rs.getInt("customer_id"),
                                rs.getString("Account_Type"),
                                rs.getDate("Registration_Date"),
                                rs.getDate("Activation_Date"),
                                rs.getInt("branch_ID"),
                                rs.getDouble("Interest"),
                                rs.getDouble("initial_deposity")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");

            dataList = FXCollections.observableArrayList(data);

            myDataTable.setItems((ObservableList<Account>) dataList);

            if(data.isEmpty()) {
                answer= "Nothing was found";
            } else {
                answer= "Found";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return answer;
    }
    
    public void comboBox(ComboBox<String> comboBox){
        try {
            data.clear();
            getData();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < data.size(); i++) {
            comboBox.getItems().add(data.get(i).getAccountId()+"");
        }
    }
}

