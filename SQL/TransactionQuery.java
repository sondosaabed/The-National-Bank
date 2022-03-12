package SQL;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Sample.Transaction;
import sqlStyle.choice;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/* 
    This class is used to make a transaction query including (delete, insert, update, search)
*/
public class TransactionQuery {
    public ObservableList<Transaction> dataList;
    public ArrayList<Transaction> data = new ArrayList<>();
    public ArrayList<Integer> id = new ArrayList<>();
 
    DataBaseConnection connectionTOSQL = new DataBaseConnection();

    @SuppressWarnings("unchecked")
    public void tableView(Stage stage, GridPane pane) {
        TableView<Transaction> myDataTable = new TableView<Transaction>();

        Scene scene = new Scene(pane);
        stage.setTitle("Transaction Table");

        TableColumn<Transaction, Integer> id = new TableColumn<Transaction, Integer>("Number");
        id.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("transactionID"));

        TableColumn<Transaction, Date> transpositionDate = new TableColumn<Transaction,Date>("Transaction Date");
        transpositionDate.setCellValueFactory(new PropertyValueFactory<Transaction, Date>("transpositionDate"));

        TableColumn<Transaction, String> transpositionType = new TableColumn<Transaction, String>("Transposition Type");
        transpositionType.setCellValueFactory(new PropertyValueFactory<Transaction, String>("transpositionType"));

        TableColumn<Transaction, Double> transpositionAmount = new TableColumn<Transaction, Double>("Amount");
        transpositionAmount.setCellValueFactory(new PropertyValueFactory<Transaction, Double>("transpositionAmount"));

        TableColumn<Transaction, Integer> employeeID = new TableColumn<Transaction, Integer>("employeID");
        employeeID.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("employeeID"));

        TableColumn<Transaction, Integer> customer = new TableColumn<Transaction, Integer>("customer id");
        customer.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("customer_id"));

        myDataTable.setItems(dataList);
        myDataTable.getColumns().addAll(id,transpositionDate,transpositionType,transpositionAmount,employeeID,customer);
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

    private void getTransactionData() throws SQLException, ClassNotFoundException {
        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from transactions";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )
            data.add(new Transaction(
                    Integer.parseInt(rs.getString(1)),
                    Date.valueOf(rs.getString(2)),
                    rs.getString(3),
                    Double.parseDouble(rs.getString(4)),
                    Integer.parseInt(rs.getString(5)),
                    Integer.parseInt(rs.getString(6))));
        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
    }
    public void getData() throws SQLException, ClassNotFoundException {
        getTransactionData();
    }

    public void insertData(Transaction rc) {

        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into transactions (Transposition_date, Transposition_type, Transposition_amount, employee_ID, customer_id) values('"
                    +rc.getTranspositionDate()+"','"
                    + rc.getTranspositionType() +"',"
                    + rc.getTranspositionAmount()+","
                    +rc.getEmployeeID()+","
                    +rc.getCustomer_id()+");");

            connectionTOSQL.getCon().close();
            System.out.println("Connection closed" + data.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public String delete(ArrayList<choice> conditions) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Delete from transactions Where ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Transposition_date" || conditions.get(i).getType() == "Transposition_type") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Transposition_date" || conditions.get(i).getType() == "Transposition_type") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans=    connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="transactions Deleted";
	            } else {
	                answer ="transactions not Deleted";
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
	            String sql="Update transactions SET ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<choices.size();i++) {
	                if(i==choices.size()-1) {
	                    if (conditions.get(i).getType() == "Transposition_date" || conditions.get(i).getType() == "Transposition_type") {
	                        sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(choices.get(i).getType() + " = "  + choices.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Transposition_date" || conditions.get(i).getType() == "Transposition_type") {
	                    sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'" + ", ");
	                }else{
	                    sql= sql.concat(choices.get(i).getType() +" = " +choices.get(i).getValue()+ ", ");
	                }
	            }
	
	            sql = sql.concat(" Where ");
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Transposition_date" || conditions.get(i).getType() == "Transposition_type") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Transposition_date" || conditions.get(i).getType() == "Transposition_type") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="transactions Updated";
	            } else {
	                answer ="transactions not updated";
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

    public ArrayList<Integer> id(){
        try {
            data.clear();
            getData();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < data.size(); i++) {
            id.add(data.get(i).getTransactionID());
        }
    	return id;
    }
   
	public String search(ArrayList<choice> conditions,ArrayList<choice> show, GridPane pane5, int i, int j) {
        ObservableList<Transaction> dataList = null ;
        TableView<Transaction> myDataTable = new TableView<Transaction>();
        ArrayList<Transaction> data = new ArrayList<>();
        
    	String answer="";
    	try {
            String sql="Select *";
            connectionTOSQL.connect();
            
    		for(int i2 =0; i2<show.size();i2++) {

	    		if(show.get(i2).getType() == "Transaction_ID") {
	    	        TableColumn<Transaction, Integer> id = new TableColumn<Transaction, Integer>("Number");
	    	        id.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("transactionID"));
	    	        myDataTable.getColumns().add(id);
	    		} else if(show.get(i2).getType() == "Transposition_date") {
	    	        TableColumn<Transaction, Date> transpositionDate = new TableColumn<Transaction,Date>("Transaction Date");
	    	        transpositionDate.setCellValueFactory(new PropertyValueFactory<Transaction, Date>("transpositionDate"));
	    	        myDataTable.getColumns().add(transpositionDate);
	    		}else if(show.get(i2).getType() == "Transposition_type") {
	    	        TableColumn<Transaction, String> transpositionType = new TableColumn<Transaction, String>("Transposition Type");
	    	        transpositionType.setCellValueFactory(new PropertyValueFactory<Transaction, String>("transpositionType"));
	    	        myDataTable.getColumns().add(transpositionType);
	    		}else if(show.get(i2).getType() == "Transposition_amount") {
	    	        TableColumn<Transaction, Double> transpositionAmount = new TableColumn<Transaction, Double>("Amount");
	    	        transpositionAmount.setCellValueFactory(new PropertyValueFactory<Transaction, Double>("transpositionAmount"));
	    	        myDataTable.getColumns().add(transpositionAmount);
	    		}else if(show.get(i2).getType() == "employee_ID") {
	    	        TableColumn<Transaction, Integer> employeeID = new TableColumn<Transaction, Integer>("employeID");
	    	        employeeID.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("employeeID"));
	    	        myDataTable.getColumns().add(employeeID);
	    		}else if(show.get(i2).getType() == "customer_id") {
	    	        TableColumn<Transaction, Integer> customer = new TableColumn<Transaction, Integer>("customer id");
	    	        customer.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("customer_id"));
	    	        myDataTable.getColumns().add(customer);
	    		}
	    	}
	    	sql= sql.concat(" From transactions Where ");
    		for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Transposition_type" || conditions.get(i1).getType() == "Transposition_date") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Transposition_type" || conditions.get(i1).getType() == "Transposition_date"){
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
                		new Transaction(
                                rs.getInt("Transaction_ID"),
                                rs.getDate("Transposition_date"),
                                rs.getString("Transposition_type"),
                                rs.getDouble("Transposition_amount"),
                                rs.getInt("employee_ID"),
                                rs.getInt("customer_id")
                			)		
                 );
            rs.close();
            stmt.close();
	        connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            
            dataList = FXCollections.observableArrayList(data);

	        myDataTable.setItems((ObservableList<Transaction>) dataList);
	    	
	        if(data.isEmpty()) {
	    		answer= "Nothing was found";
	    	} else {
	    		pane5.add(myDataTable,1,1);
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
        ObservableList<Transaction> dataList = null ;
        TableView<Transaction> myDataTable = new TableView<Transaction>();
        ArrayList<Transaction> data = new ArrayList<>();

        String answer="";
        try {
            String sql="Select *";
            connectionTOSQL.connect();
            sql= sql.concat(" From transactions Where ");
            for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Transposition_type" || conditions.get(i1).getType() == "Transposition_date") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Transposition_type" || conditions.get(i1).getType() == "Transposition_date"){
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
                        new Transaction(
                                rs.getInt("Transaction_ID"),
                                rs.getDate("Transposition_date"),
                                rs.getString("Transposition_type"),
                                rs.getDouble("Transposition_amount"),
                                rs.getInt("employee_ID"),
                                rs.getInt("customer_id")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");

            dataList = FXCollections.observableArrayList(data);

            myDataTable.setItems((ObservableList<Transaction>) dataList);

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
}
