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
import Sample.Card;
import sqlStyle.choice;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/* 
    This class is used to make an card query including (delete, insert, update, search)
*/

public class CardQuery {
    public ObservableList<Card> dataList;
    public ArrayList<Card> data = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();

    @SuppressWarnings("unchecked")
    public void tableView(Stage stage, GridPane pane) {
        TableView<Card> myDataTable = new TableView<Card>();

        Scene scene = new Scene(pane);
        stage.setTitle("Card");

        TableColumn<Card, Integer> id = new TableColumn<Card, Integer>("Number");
        id.setCellValueFactory(new PropertyValueFactory<Card, Integer>("creditID"));

        TableColumn<Card, Double> limit = new TableColumn<Card, Double>("limit");
        limit.setCellValueFactory(new PropertyValueFactory<Card, Double>("limit"));

        TableColumn<Card, Date> expDate = new TableColumn<Card,Date>("Expiration date");
        expDate.setCellValueFactory(new PropertyValueFactory<Card, Date>("expDate"));

        TableColumn<Card, Integer> customerId = new TableColumn<Card, Integer>("Customer ID");
        customerId.setCellValueFactory(new PropertyValueFactory<Card, Integer>("customerId"));

        myDataTable.setItems(dataList);
        myDataTable.getColumns().addAll(id, limit ,expDate,customerId);
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

    private void getCardData() throws SQLException, ClassNotFoundException {
        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from card";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            data.add(new Card(
                    Integer.parseInt(rs.getString(1)),
                    Double.parseDouble(rs.getString(2)),
                    Date.valueOf(rs.getString(3)),
                    Integer.parseInt(rs.getString(4))));

        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
    }

    public void insertData(Card rc) {
        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into Card (card_ID, card_limit, card_exp_date, customer_id) values("
                    + rc.getCreditID() +","
                    + rc.getLimit() +",'"
                    + rc.getExpDate() +"',"
                    + rc.getCustomerId()  +");");

            connectionTOSQL.getCon().close();
            System.out.println("Connection closed" + data.size());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void getData() throws SQLException, ClassNotFoundException {
        getCardData();
    }
    
    public String delete(ArrayList<choice> conditions) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Delete from card Where ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "card_exp_date") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "card_exp_date") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans=    connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="card Deleted";
	            } else {
	                answer ="card not Deleted";
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
	            String sql="Update card SET ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<choices.size();i++) {
	                if(i==choices.size()-1) {
	                    if (conditions.get(i).getType() == "card_exp_date") {
	                        sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(choices.get(i).getType() + " = "  + choices.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "card_exp_date") {
	                    sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'" + ", ");
	                }else{
	                    sql= sql.concat(choices.get(i).getType() +" = " +choices.get(i).getValue()+ ", ");
	                }
	            }
	
	            sql = sql.concat(" Where ");
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "card_exp_date") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "card_exp_date") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="card Updated";
	            } else {
	                answer ="card not updated";
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
        ObservableList<Card> dataList = null ;
        TableView<Card> myDataTable = new TableView<Card>();
        ArrayList<Card> data = new ArrayList<>();
        
    	String answer="";
    	try {
            String sql="Select *";
            connectionTOSQL.connect();
            
    		for(int i2 =0; i2<show.size();i2++) {
	    		if(show.get(i2).getType() == "card_ID") {
	    	        TableColumn<Card, Integer> id = new TableColumn<Card, Integer>("Number");
	    	        id.setCellValueFactory(new PropertyValueFactory<Card, Integer>("creditID"));
	    	         myDataTable.getColumns().add(id);
	    		} else if(show.get(i2).getType() == "card_limit") {
	    			  TableColumn<Card, Double> limit = new TableColumn<Card, Double>("limit");
		    	        limit.setCellValueFactory(new PropertyValueFactory<Card, Double>("limit"));
		    	        myDataTable.getColumns().add(limit);
	    		}else if(show.get(i2).getType() == "card_exp_date") {
	    	        TableColumn<Card, Date> expDate = new TableColumn<Card,Date>("Expiration date");
	    	        expDate.setCellValueFactory(new PropertyValueFactory<Card, Date>("expDate"));
	    	        myDataTable.getColumns().add(expDate);
	    		}else if(show.get(i2).getType() == "customer_id") {
	    			TableColumn<Card, Integer> customerId = new TableColumn<Card, Integer>("Customer ID");
	    	        customerId.setCellValueFactory(new PropertyValueFactory<Card, Integer>("customerId"));
	    	       myDataTable.getColumns().add(customerId);
	    		}
	    		
	    	}
	    	sql= sql.concat(" From Card Where ");
    		for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "card_exp_date") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "card_exp_date") {
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
                		new Card(
                		        rs.getInt("card_ID"),
                                rs.getDouble("card_limit"),
                                rs.getDate("card_exp_date"),
                                rs.getInt("customer_id")
                				)		
                 );
            rs.close();
            stmt.close();
	        connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            
            dataList = FXCollections.observableArrayList(data);

	        myDataTable.setItems((ObservableList<Card>) dataList);
	    	
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
        ObservableList<Card> dataList = null ;
        TableView<Card> myDataTable = new TableView<Card>();
        ArrayList<Card> data = new ArrayList<>();

        String answer="";
        try {
            String sql="Select *";
            connectionTOSQL.connect();
            sql= sql.concat(" From Card Where ");
            for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "card_exp_date") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "card_exp_date") {
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
                        new Card(
                                rs.getInt("card_ID"),
                                rs.getDouble("card_limit"),
                                rs.getDate("card_exp_date"),
                                rs.getInt("customer_id")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");

            dataList = FXCollections.observableArrayList(data);

            myDataTable.setItems((ObservableList<Card>) dataList);

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
