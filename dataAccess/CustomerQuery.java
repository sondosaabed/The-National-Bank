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

import application.Customer;

/* 
    This class is used to make an customer query including (delete, insert, update, search)
*/

public class CustomerQuery {
    public ObservableList<Customer> dataList;
    public  ArrayList<Customer> data = new ArrayList<>();
    public ArrayList<Integer> id = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();

    @SuppressWarnings("unchecked")
    public void tableView(Stage stage, GridPane pane) {
        TableView<Customer> myDataTable = new TableView<Customer>();

        Scene scene = new Scene(pane);
        stage.setTitle("Customer");

        TableColumn<Customer, Integer> id = new TableColumn<Customer, Integer>("Number");
        id.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerID"));

        TableColumn<Customer, String> nameCol = new TableColumn<Customer, String>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));

        TableColumn<Customer, Integer> phoneCol = new TableColumn<Customer, Integer>("Phone");
        phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerPhone"));

        TableColumn<Customer, Date> DOBCol = new TableColumn<Customer, Date>("DOB");
        DOBCol.setCellValueFactory(new PropertyValueFactory<Customer, Date>("DOB"));

        TableColumn<Customer, String> genderCol = new TableColumn<Customer, String>("gender");
        genderCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("gender"));

        TableColumn<Customer, Integer> Postal_code = new TableColumn<Customer, Integer>("address");
        Postal_code.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("address"));

        myDataTable.setItems(dataList);
        myDataTable.getColumns().addAll(id, nameCol ,phoneCol,DOBCol,genderCol,Postal_code);
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

    public ObservableList<Customer> getDataList() {
        return dataList;
    }

    public void setDataList(ObservableList<Customer> dataList) {
        this.dataList = dataList;
    }

    private void getCustomerData() throws SQLException, ClassNotFoundException {

        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from customer";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )
            data.add(new Customer(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    Integer.parseInt(rs.getString(3)),
                    Date.valueOf(rs.getString(4)),
                    rs.getString(5),
                    Integer.parseInt(rs.getString(6))));

        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());


    }
    public void getData() throws SQLException, ClassNotFoundException {
        getCustomerData();
    }

    public void insertData(Customer rc) {

        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into customer (customer_name, customer_phone, customer_DOB, customer_Gender, address_ID) values('"
                    +rc.getName()+"',"
                    + rc.getCustomerPhone() +",'"
                    + rc.getDOB() +"','"
                    + rc.getGender() +"',"
                    + rc.getAddress()+");");
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed" + data.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void getDataForCustomer() throws SQLException, ClassNotFoundException {

        String SQL;

        connectionTOSQL.connect();
        System.out.println("Connection established");
        SQL = "select customer_id from customer;";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )
            data.add(new Customer(
                    Integer.parseInt(rs.getString(1))));
        rs.close();
        stmt.close();

        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
    }
    public void getDataID() throws SQLException, ClassNotFoundException {
        getDataForCustomer();
    }

    public void comboBox(ComboBox<String> comboBox){
        try {
            data.clear();
            getDataID();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < data.size(); i++) {
            comboBox.getItems().add(data.get(i).getCustomerID()+"");
        }
    }

    public String delete(ArrayList<choice> conditions) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Delete from Customer Where ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "customer_name" || conditions.get(i).getType() == "customer_DOB" || conditions.get(i).getType() == "customer_Gender") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "customer_name" || conditions.get(i).getType() == "customer_DOB" || conditions.get(i).getType() == "customer_Gender") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans=    connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="Customer Deleted";
	            } else {
	                answer ="Customer not Deleted";
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
	            String sql="Update customer SET ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<choices.size();i++) {
	                if(i==choices.size()-1) {
	                    if (conditions.get(i).getType() == "customer_name" || conditions.get(i).getType() == "customer_DOB" || conditions.get(i).getType() == "customer_Gender") {
	                        sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(choices.get(i).getType() + " = "  + choices.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "customer_name" || conditions.get(i).getType() == "customer_DOB" || conditions.get(i).getType() == "customer_Gender") {
	                    sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'" + ", ");
	                }else{
	                    sql= sql.concat(choices.get(i).getType() +" = " +choices.get(i).getValue()+ ", ");
	                }
	            }
	
	            sql = sql.concat(" Where ");
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "customer_name" || conditions.get(i).getType() == "customer_DOB" || conditions.get(i).getType() == "customer_Gender") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "customer_name" || conditions.get(i).getType() == "customer_DOB" || conditions.get(i).getType() == "customer_Gender") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="customer Updated";
	            } else {
	                answer ="customer not updated";
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
        ObservableList<Customer> dataList = null ;
        TableView<Customer> myDataTable = new TableView<Customer>();
        ArrayList<Customer> data = new ArrayList<>();
        
    	String answer="";
    	try {
            String sql="Select *";
            connectionTOSQL.connect();
           
    		for(int i2 =0; i2<show.size();i2++) {
	    		if(show.get(i2).getType() == "customer_id") {
	    	        TableColumn<Customer, Integer> id = new TableColumn<Customer, Integer>("Number");
	    	        id.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerID"));
	    	        myDataTable.getColumns().add(id);
	    		} else if(show.get(i2).getType() == "customer_name") {
	    	        TableColumn<Customer, String> nameCol = new TableColumn<Customer, String>("Name");
	    	        nameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("Name"));
	    	        myDataTable.getColumns().add(nameCol);
	    		}else if(show.get(i2).getType() == "customer_phone") {
	    	        TableColumn<Customer, Integer> phoneCol = new TableColumn<Customer, Integer>("Phone");
	    	        phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("customerPhone"));
	    	        myDataTable.getColumns().add(phoneCol);
	    		}else if(show.get(i2).getType() == "customer_DOB") {
	    	        TableColumn<Customer, Date> DOBCol = new TableColumn<Customer, Date>("DOB");
	    	        DOBCol.setCellValueFactory(new PropertyValueFactory<Customer, Date>("DOB"));
	    	        myDataTable.getColumns().add(DOBCol);
	    		}else if(show.get(i2).getType() == "customer_Gender") {
	    	        TableColumn<Customer, String> genderCol = new TableColumn<Customer, String>("gender");
	    	        genderCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("gender"));
	    	        myDataTable.getColumns().add(genderCol);
	    		}else if(show.get(i2).getType() == "address_ID") {
	    			 TableColumn<Customer, Integer> Postal_code = new TableColumn<Customer, Integer>("address");
		    	     Postal_code.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("address"));
		    	     myDataTable.getColumns().add(Postal_code);
	    		}
	    	}
	    	sql= sql.concat(" From Customer Where ");
    		for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "customer_name" || conditions.get(i1).getType() == "customer_DOB" || conditions.get(i1).getType() == "customer_Gender") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "customer_name" || conditions.get(i1).getType() == "customer_DOB" || conditions.get(i1).getType() == "customer_Gender") {
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
                		new Customer(
                		        rs.getInt("customer_id"),
                                rs.getString("customer_name"),
                                rs.getInt("customer_phone"),
                                rs.getDate("customer_DOB"),
                                rs.getString("customer_Gender"),
                                rs.getInt("address_ID")
                				)		
                 );
            rs.close();
            stmt.close();
	        connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            
            dataList = FXCollections.observableArrayList(data);

	        myDataTable.setItems((ObservableList<Customer>) dataList);
	    	
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
        ObservableList<Customer> dataList = null ;
        TableView<Customer> myDataTable = new TableView<Customer>();
        ArrayList<Customer> data = new ArrayList<>();

        String answer="";
        try {
            String sql="Select *";
            connectionTOSQL.connect();
            sql= sql.concat(" From Customer Where ");
            for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "customer_name" || conditions.get(i1).getType() == "customer_DOB" || conditions.get(i1).getType() == "customer_Gender") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "customer_name" || conditions.get(i1).getType() == "customer_DOB" || conditions.get(i1).getType() == "customer_Gender") {
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
                        new Customer(
                                rs.getInt("customer_id"),
                                rs.getString("customer_name"),
                                rs.getInt("customer_phone"),
                                rs.getDate("customer_DOB"),
                                rs.getString("customer_Gender"),
                                rs.getInt("address_ID")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");

            dataList = FXCollections.observableArrayList(data);

            myDataTable.setItems((ObservableList<Customer>) dataList);

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
