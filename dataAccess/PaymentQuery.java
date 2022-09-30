package dataAccess;

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
import presentation.choice;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.Payment;
/* 
    This class is used to make a payment query including (delete, insert, update, search)
*/
public class PaymentQuery {
    public ObservableList<Payment> dataList;
    public ArrayList<Payment> data = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();

    @SuppressWarnings("unchecked")
	public void tableView(Stage stage, GridPane pane) {
        TableView<Payment> myDataTable = new TableView<Payment>();

        Scene scene = new Scene(pane);
        stage.setTitle("Payment Table");

        TableColumn<Payment, Integer> id = new TableColumn<Payment, Integer>("Number");
        id.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("paymentNumber"));

        TableColumn<Payment, Double> paymentAmount = new TableColumn<Payment, Double>("Amount");
        paymentAmount.setCellValueFactory(new PropertyValueFactory<Payment, Double>("paymentAmount"));

        TableColumn<Payment, Date> paymentDate = new TableColumn<Payment,Date>("Payment Date");
        paymentDate.setCellValueFactory(new PropertyValueFactory<Payment, Date>("paymentDate"));

        TableColumn<Payment, Integer> loanNumber = new TableColumn<Payment, Integer>("Loan Number");
        loanNumber.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("loanNumber"));

        myDataTable.setItems(dataList);
        myDataTable.getColumns().addAll(id, paymentAmount ,paymentDate,loanNumber);
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
        GridPane.setHalignment(close, HPos.CENTER);
        pane.add(close,1,2);
        stage.setScene(scene);
    }

    private void getPaymentData() throws SQLException, ClassNotFoundException {
        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from payment";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            data.add(new Payment(
                    Integer.parseInt(rs.getString(1)),
                    Double.parseDouble(rs.getString(2)),
                    Date.valueOf(rs.getString(3)),
                    Integer.parseInt(rs.getString(4))));

        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
    }
    
    public void getData() throws SQLException, ClassNotFoundException {
        getPaymentData();
    }

    public void insertData(Payment rc) {
        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into payment (Payment_amount, Payment_date, Loan_number) values("
                    +rc.getPaymentAmount()+",'"
                    + rc.getPaymentDate() +"',"
                    + rc.getLoanNumber()  +");");

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
	            String sql="Delete from payment Where ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Payment_date") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Payment_date") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans=    connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="Payment Deleted";
	            } else {
	                answer ="Payment not Deleted";
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
	            String sql="Update payment SET ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<choices.size();i++) {
	                if(i==choices.size()-1) {
	                    if (conditions.get(i).getType() == "Payment_date") {
	                        sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(choices.get(i).getType() + " = "  + choices.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Payment_date") {
	                    sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'" + ", ");
	                }else{
	                    sql= sql.concat(choices.get(i).getType() +" = " +choices.get(i).getValue()+ ", ");
	                }
	            }
	
	            sql = sql.concat(" Where ");
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Payment_date") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Payment_date") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="payment Updated";
	            } else {
	                answer ="payment not updated";
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
        ObservableList<Payment> dataList = null ;
        TableView<Payment> myDataTable = new TableView<Payment>();
        ArrayList<Payment> data = new ArrayList<>();
        
    	String answer="";
    	try {
            String sql="Select *";
            connectionTOSQL.connect();
            
    		for(int i2 =0; i2<show.size();i2++) {
	    		if(show.get(i2).getType() == "Payment_Number") {
	    	        TableColumn<Payment, Integer> id = new TableColumn<Payment, Integer>("Number");
	    	        id.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("paymentNumber"));
	    	        myDataTable.getColumns().add(id);
	    		} else if(show.get(i2).getType() == "Payment_amount") {
	    	        TableColumn<Payment, Double> paymentAmount = new TableColumn<Payment, Double>("Amount");
	    	        paymentAmount.setCellValueFactory(new PropertyValueFactory<Payment, Double>("paymentAmount"));
	    	        myDataTable.getColumns().add(paymentAmount);
	    		}else if(show.get(i2).getType() == "Payment_date") {
	    	        TableColumn<Payment, Date> paymentDate = new TableColumn<Payment,Date>("Payment Date");
	    	        paymentDate.setCellValueFactory(new PropertyValueFactory<Payment, Date>("paymentDate"));
	    	        myDataTable.getColumns().add(paymentDate);
	    		}else if(show.get(i2).getType() == "Loan_number") {
	    	        TableColumn<Payment, Integer> loanNumber = new TableColumn<Payment, Integer>("Loan Number");
	    	        loanNumber.setCellValueFactory(new PropertyValueFactory<Payment, Integer>("loanNumber"));
	    	        myDataTable.getColumns().add(loanNumber);
	    		}
	    	}
	    	sql= sql.concat(" From payment Where ");
    		for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Payment_date" ) {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Payment_date" ){
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
                		new Payment(
                                rs.getInt("Payment_Number"),
                                rs.getDouble("Payment_amount"),
                                rs.getDate("Payment_date"),
                                rs.getInt("Loan_number")
                				)		
                 );
            rs.close();
            stmt.close();
	        connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            
            dataList = FXCollections.observableArrayList(data);

	        myDataTable.setItems((ObservableList<Payment>) dataList);
	    	
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
        ObservableList<Payment> dataList = null ;
        TableView<Payment> myDataTable = new TableView<Payment>();
        ArrayList<Payment> data = new ArrayList<>();

        String answer="";
        try {
            String sql="Select *";
            connectionTOSQL.connect();
            sql= sql.concat(" From payment Where ");
            for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Payment_date" ) {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Payment_date" ){
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
                        new Payment(
                                rs.getInt("Payment_Number"),
                                rs.getDouble("Payment_amount"),
                                rs.getDate("Payment_date"),
                                rs.getInt("Loan_number")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");

            dataList = FXCollections.observableArrayList(data);

            myDataTable.setItems((ObservableList<Payment>) dataList);

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
