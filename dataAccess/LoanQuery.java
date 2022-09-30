package dataAccess;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

import application.Loan;
/* 
    This class is used to make a loan query including (delete, insert, update, search)
*/
public class LoanQuery {
    public ObservableList<Loan> dataList;
    public ArrayList<Loan> data = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();

    @SuppressWarnings("unchecked")
    public void tableView(Stage stage, GridPane pane) {
        TableView<Loan> myDataTable = new TableView<Loan>();

        Scene scene = new Scene(pane);

        TableColumn<Loan, Integer> id = new TableColumn<Loan, Integer>("Number");
        id.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("loanNumber"));

        TableColumn<Loan, Double> amount = new TableColumn<Loan, Double>("Amount");
        amount.setCellValueFactory(new PropertyValueFactory<Loan, Double>("amount"));

        TableColumn<Loan, String> type = new TableColumn<Loan, String>("Loan Type");
        type.setCellValueFactory(new PropertyValueFactory<Loan, String>("type"));

        TableColumn<Loan, Integer> branchID = new TableColumn<Loan, Integer>("Branch ID");
        branchID.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("branchId"));

        TableColumn<Loan, Integer> customerId = new TableColumn<Loan, Integer>("Customer ID");
        customerId.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("customerId"));

        TableColumn<Loan, Date> loanDate = new TableColumn<Loan, Date>("Loan Date");
        loanDate.setCellValueFactory(new PropertyValueFactory<Loan, Date>("loanDate"));

        myDataTable.setItems(dataList);
        myDataTable.getColumns().addAll(id, amount ,type,branchID,customerId,loanDate);
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
    private void getCustomerData() throws SQLException, ClassNotFoundException {
        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from loan";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            data.add(new Loan(
                    Integer.parseInt(rs.getString(1)),
                    Double.parseDouble(rs.getString(2)),
                    rs.getString(3),
                    Integer.parseInt(rs.getString(4)),
                    Integer.parseInt(rs.getString(5)),
                    Date.valueOf(rs.getString(6))));

        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
    }
    
    public void getData() throws SQLException, ClassNotFoundException {
        getCustomerData();
    }

    public void insertData(Loan rc) {
        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into loan (Loan_amount, Loan_type, Branch_ID, customer_id, loan_date) values("
                    +rc.getAmount()+",'"
                    + rc.getType() +"',"
                    + rc.getBranchId() +","
                    + rc.getCustomerId() +",'"
                    + rc.getLoanDate()+"');");
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed" + data.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
            comboBox.getItems().add(data.get(i).getLoanNumber()+"");
        }
    }

    public String delete(ArrayList<choice> conditions) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Delete from Loan Where ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Loan_type" || conditions.get(i).getType() == "loan_date") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Loan_type" || conditions.get(i).getType() == "loan_date") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans=    connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="Loan Deleted";
	            } else {
	                answer ="Loan not Deleted";
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
    
    public String update(ArrayList<choice> conditions, ArrayList<choice> choices) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Update Loan SET ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<choices.size();i++) {
	                if(i==choices.size()-1) {
	                    if (conditions.get(i).getType() == "Loan_type" || conditions.get(i).getType() == "loan_date") {
	                        sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(choices.get(i).getType() + " = "  + choices.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Loan_type" || conditions.get(i).getType() == "loan_date") {
	                    sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'" + ", ");
	                }else{
	                    sql= sql.concat(choices.get(i).getType() +" = " +choices.get(i).getValue()+ ", ");
	                }
	            }
	
	            sql = sql.concat(" Where ");
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Loan_type" || conditions.get(i).getType() == "loan_date") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Loan_type" || conditions.get(i).getType() == "loan_date") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="Loan Updated";
	            } else {
	                answer ="Loan not updated";
	            }
	            connectionTOSQL.getCon().close();
	            System.out.println("Connection closed");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
        }else{
            answer ="Nothing was found To update"; 
        }
        
        return answer;
    }
	public String search(ArrayList<choice> conditions,ArrayList<choice> show, GridPane pane5, int i, int j) {
        ObservableList<Loan> dataList = null ;
        TableView<Loan> myDataTable = new TableView<Loan>();
        ArrayList<Loan> data = new ArrayList<>();
        
    	String answer="";
    	try {
            String sql="Select *";
            connectionTOSQL.connect();
    		for(int i2 =0; i2<show.size();i2++) {
	    		if(show.get(i2).getType() == "Loan_number") {
	    	        TableColumn<Loan, Integer> id = new TableColumn<Loan, Integer>("Number");
	    	        id.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("loanNumber"));
	    	        myDataTable.getColumns().add(id);
	    		} else if(show.get(i2).getType() == "Loan_amount") {
	    	        TableColumn<Loan, Double> amount = new TableColumn<Loan, Double>("Amount");
	    	        amount.setCellValueFactory(new PropertyValueFactory<Loan, Double>("amount"));
	    	        myDataTable.getColumns().add(amount);
	    		}else if(show.get(i2).getType() == "Loan_type") {
	    			  TableColumn<Loan, String> type = new TableColumn<Loan, String>("Loan Type");
		    	        type.setCellValueFactory(new PropertyValueFactory<Loan, String>("type"));
	    	        myDataTable.getColumns().add(type);
	    		}else if(show.get(i2).getType() == "Branch_ID") {
	    			 TableColumn<Loan, Integer> branchID = new TableColumn<Loan, Integer>("Branch ID");
		    	        branchID.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("branchId"));
	    	        myDataTable.getColumns().add(branchID);
	    		}else if(show.get(i2).getType() == "customer_id") {
	    			 TableColumn<Loan, Integer> customerId = new TableColumn<Loan, Integer>("Customer ID");
		    	        customerId.setCellValueFactory(new PropertyValueFactory<Loan, Integer>("customerId"));
	    	        myDataTable.getColumns().add(customerId);
	    		}else if(show.get(i2).getType() == "loan_date") {
	    	        TableColumn<Loan, Date> loanDate = new TableColumn<Loan, Date>("Loan Date");
	    	        loanDate.setCellValueFactory(new PropertyValueFactory<Loan, Date>("loanDate"));
	    	        myDataTable.getColumns().add(loanDate);
	    		}
	    	}
	    	sql= sql.concat(" From Loan Where ");
    		for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Loan_type" || conditions.get(i1).getType() == "loan_date") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Loan_type" || conditions.get(i1).getType() == "loan_date") {
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
                		new Loan(
                		        rs.getInt("Loan_number"),
                                rs.getDouble("Loan_amount"),
                                rs.getString("Loan_type"),
                                rs.getInt("Branch_ID"),
                                rs.getInt("customer_id"),
                                rs.getDate("loan_date")
                				)		
                 );
            rs.close();
            stmt.close();
	        connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            
            dataList = FXCollections.observableArrayList(data);

	        myDataTable.setItems((ObservableList<Loan>) dataList);
	    	
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
        ObservableList<Loan> dataList = null;
        TableView<Loan> myDataTable = new TableView<Loan>();
        ArrayList<Loan> data = new ArrayList<>();

        String answer = "";
        try {
            String sql = "Select *";
            connectionTOSQL.connect();
            sql = sql.concat(" From Loan Where ");
            for (int i1 = 0; i1 < conditions.size(); i1++) {
                if (i1 == conditions.size() - 1) {
                    if (conditions.get(i1).getType() == "Loan_type" || conditions.get(i1).getType() == "loan_date") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    } else {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Loan_type" || conditions.get(i1).getType() == "loan_date") {
                    sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'" + " AND ");
                } else {
                    sql = sql.concat(conditions.get(i1).getType() + " = " + conditions.get(i1).getValue() + " AND ");
                }
            }
            System.out.println(sql);

            Statement stmt = connectionTOSQL.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(sql + ";");

            while (rs.next())
                data.add(
                        new Loan(
                                rs.getInt("Loan_number"),
                                rs.getDouble("Loan_amount"),
                                rs.getString("Loan_type"),
                                rs.getInt("Branch_ID"),
                                rs.getInt("customer_id"),
                                rs.getDate("loan_date")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");

            dataList = FXCollections.observableArrayList(data);

            myDataTable.setItems((ObservableList<Loan>) dataList);

            if (data.isEmpty()) {
                answer = "Nothing was found";
            } else {
                answer = "Found";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return answer;
    }

	public boolean update(int loanId, double paymentAmount) throws SQLException, ClassNotFoundException {
        double amount = 0;
        String SQL = "select Loan_amount from loan where Loan_Number = " + loanId + ";";
        connectionTOSQL.connect();
        System.out.println("Connection established");
        System.out.println(SQL);
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);
        while (rs.next()) {
            amount = rs.getDouble("Loan_amount");
            System.out.println(amount + "\n");
        }
        System.out.println(rs);
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed");
        if (amount == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Loan Amount have " + amount+"$" + " Payment");
            alert.showAndWait();
            return false;
        } else if (amount >= paymentAmount) {
            String SQL1;
            connectionTOSQL.connect();
            System.out.println("Connection established");
            SQL1 = "update loan set Loan_amount =" + "Loan_amount -" + paymentAmount + " where Loan_number =" + loanId + ";";
            System.out.println(SQL1);
            Statement stmt2 = connectionTOSQL.getCon().createStatement();
            stmt2.executeUpdate(SQL1);
            stmt2.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Loan only have " + amount+ " Payment");
            alert.showAndWait();
        }
        return false;
    }
}
