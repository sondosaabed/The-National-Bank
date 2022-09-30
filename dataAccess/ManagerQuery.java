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

import application.Manager;
/* 
    This class is used to make a manager query including (delete, insert, update, search)
*/
public class ManagerQuery {
    public ObservableList<Manager> dataList;
    public ArrayList<Manager> data = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();
    Manager manager ;

    @SuppressWarnings("unchecked")
    public void tableView(Stage stage, GridPane pane) {
        TableView<Manager> myDataTable = new TableView<Manager>();

        Scene scene = new Scene(pane);
        stage.setTitle("Manager Table");

        TableColumn<Manager, Integer> id = new TableColumn<Manager, Integer>("Number");
        id.setCellValueFactory(new PropertyValueFactory<Manager, Integer>("managerId"));

        TableColumn<Manager, String> nameCol = new TableColumn<Manager, String>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Manager, String>("manageName"));

        TableColumn<Manager, Integer> phone = new TableColumn<Manager, Integer>("Phone");
        phone.setCellValueFactory(new PropertyValueFactory<Manager, Integer>("managerPhone"));

        TableColumn<Manager, Date> DOBCol = new TableColumn<Manager,Date>("DOB");
        DOBCol.setCellValueFactory(new PropertyValueFactory<Manager, Date>("managerBOB"));

        TableColumn<Manager, String> genderCol = new TableColumn<Manager, String>("Gender");
        genderCol.setCellValueFactory(new PropertyValueFactory<Manager, String>("gender"));

        TableColumn<Manager, String> email = new TableColumn<Manager, String>("Email");
        email.setCellValueFactory(new PropertyValueFactory<Manager, String>("email"));

        TableColumn<Manager, Double> salary = new TableColumn<Manager, Double>("Salary");
        salary.setCellValueFactory(new PropertyValueFactory<Manager, Double>("salary"));

        TableColumn<Manager, Integer> address = new TableColumn<Manager, Integer>("address");
        address.setCellValueFactory(new PropertyValueFactory<Manager, Integer>("address"));

        myDataTable.setItems(dataList);
        myDataTable.getColumns().addAll(id, nameCol ,phone,DOBCol,genderCol,email,salary,address);
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

    private void getManagerData() throws SQLException, ClassNotFoundException {
        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from manager";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);


        while ( rs.next() )
            data.add(new Manager(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    Integer.parseInt(rs.getString(3)),
                    Date.valueOf(rs.getString(4)),
                    rs.getString(5),
                    rs.getString(6),
                    Double.parseDouble(rs.getString(7)),
                    Integer.parseInt(rs.getString(8)))
            		);

        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());


    }
    public void getData() throws SQLException, ClassNotFoundException {
        getManagerData();
    }

    public void insertData(Manager rc) {
        try {
            connectionTOSQL.connect();
            connectionTOSQL.ExecuteStatement("Insert into manager (Manage_name, Manager_phone, Manager_BOB, Manager_Gender, Manage_Email, Manage_Salary, address_ID) values('" +rc.getManageName()+"'," + rc.getManagerPhone() +",'" + rc.getManagerBOB() +"','" + rc.getGender() +"','" + rc.getEmail()+"'," + rc.getSalary()+"," + rc.getAddress()+");");
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
	            String sql="Delete from manager Where ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Manage_name" || conditions.get(i).getType() == "Manager_BOB" || conditions.get(i).getType() == "Manager_Gender" || conditions.get(i).getType() == "Manage_Email") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Manage_name" || conditions.get(i).getType() == "Manager_BOB" || conditions.get(i).getType() == "Manager_Gender" || conditions.get(i).getType() == "Manage_Email") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans=    connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="Manager Deleted";
	            } else {
	                answer ="Manager not Deleted";
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
	            String sql="Update manager SET ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<choices.size();i++) {
	                if(i==choices.size()-1) {
	                    if (conditions.get(i).getType() == "Manage_name" || conditions.get(i).getType() == "Manager_BOB" || conditions.get(i).getType() == "Manager_Gender" || conditions.get(i).getType() == "Manage_Email") {
	                        sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(choices.get(i).getType() + " = "  + choices.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Manage_name" || conditions.get(i).getType() == "Manager_BOB" || conditions.get(i).getType() == "Manager_Gender" || conditions.get(i).getType() == "Manage_Email") {
	                    sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'" + ", ");
	                }else{
	                    sql= sql.concat(choices.get(i).getType() +" = " +choices.get(i).getValue()+ ", ");
	                }
	            }
	
	            sql = sql.concat(" Where ");
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "Manage_name" || conditions.get(i).getType() == "Manager_BOB" || conditions.get(i).getType() == "Manager_Gender" || conditions.get(i).getType() == "Manage_Email") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "Manage_name" || conditions.get(i).getType() == "Manager_BOB" || conditions.get(i).getType() == "Manager_Gender" || conditions.get(i).getType() == "Manage_Email") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="manager Updated";
	            } else {
	                answer ="manager not updated";
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
        ObservableList<Manager> dataList = null ;
        TableView<Manager> myDataTable = new TableView<Manager>();
        ArrayList<Manager> data = new ArrayList<>();

        String answer="";
        try {
            String sql="Select *";
            connectionTOSQL.connect();

            for(int i2 =0; i2<show.size();i2++) {

                 if(show.get(i2).getType() == "Manager_ID") {
                    TableColumn<Manager, Integer> id = new TableColumn<Manager, Integer>("Number");
                    id.setCellValueFactory(new PropertyValueFactory<Manager, Integer>("managerId"));
                    myDataTable.getColumns().add(id);
                }else if(show.get(i2).getType() == "Manage_name") {
                     TableColumn<Manager, String> name = new TableColumn<Manager, String>("Name");
                     name.setCellValueFactory(new PropertyValueFactory<Manager, String>("manageName"));
                     myDataTable.getColumns().add(name);
                 }else if(show.get(i2).getType() == "Manager_phone") {
                    TableColumn<Manager, Integer> phone = new TableColumn<Manager, Integer>("Phone");
                    phone.setCellValueFactory(new PropertyValueFactory<Manager, Integer>("managerPhone"));
                    myDataTable.getColumns().add(phone);
                }else if(show.get(i2).getType() == "Manager_BOB") {
                    TableColumn<Manager, Date> DOBCol = new TableColumn<Manager,Date>("DOB");
                    DOBCol.setCellValueFactory(new PropertyValueFactory<Manager, Date>("managerBOB"));
                    myDataTable.getColumns().add(DOBCol);
                }else if(show.get(i2).getType() == "Manager_Gender") {
                    TableColumn<Manager, String> genderCol = new TableColumn<Manager, String>("Gender");
                    genderCol.setCellValueFactory(new PropertyValueFactory<Manager, String>("gender"));
                    myDataTable.getColumns().add(genderCol);
                } else if(show.get(i2).getType() == "Manage_Email") {
                    TableColumn<Manager, String> email = new TableColumn<Manager, String>("Email");
                    email.setCellValueFactory(new PropertyValueFactory<Manager, String>("email"));
                    myDataTable.getColumns().add(email);
                }else if(show.get(i2).getType() == "Manage_Salary") {
                    TableColumn<Manager, Double> salary = new TableColumn<Manager, Double>("Salary");
                    salary.setCellValueFactory(new PropertyValueFactory<Manager, Double>("salary"));
                    myDataTable.getColumns().add(salary);
                }else if(show.get(i2).getType() == "address_ID") {
                    TableColumn<Manager, Integer> address = new TableColumn<Manager, Integer>("address");
                    address.setCellValueFactory(new PropertyValueFactory<Manager, Integer>("address"));
                    myDataTable.getColumns().add(address);
                }
            }
            sql= sql.concat(" From manager Where ");
            for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Manage_name" || conditions.get(i1).getType() == "Manager_BOB" || conditions.get(i1).getType() == "Manager_Gender" || conditions.get(i1).getType() == "Manage_Email") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Manage_name" || conditions.get(i1).getType() == "Manager_BOB" || conditions.get(i1).getType() == "Manager_Gender" || conditions.get(i1).getType() == "Manage_Email") {
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
                        new Manager(
                                rs.getInt("Manager_ID"),
                                rs.getString("Manage_name"),
                                rs.getInt("Manager_phone"),
                                rs.getDate("Manager_BOB"),
                                rs.getString("Manager_Gender"),
                                rs.getString("Manage_Email"),
                                rs.getDouble("Manage_Salary"),
                                rs.getInt("address_ID")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");

            dataList = FXCollections.observableArrayList(data);

            myDataTable.setItems((ObservableList<Manager>) dataList);

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
        ObservableList<Manager> dataList = null ;
        TableView<Manager> myDataTable = new TableView<Manager>();
        ArrayList<Manager> data = new ArrayList<>();

        String answer="";
        try {
            String sql="Select *";
            connectionTOSQL.connect();
            sql= sql.concat(" From manager Where ");
            for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "Manage_name" || conditions.get(i1).getType() == "Manager_BOB" || conditions.get(i1).getType() == "Manager_Gender" || conditions.get(i1).getType() == "Manage_Email") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "Manage_name" || conditions.get(i1).getType() == "Manager_BOB" || conditions.get(i1).getType() == "Manager_Gender" || conditions.get(i1).getType() == "Manage_Email") {
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
                        new Manager(
                                rs.getInt("Manager_ID"),
                                rs.getString("Manage_name"),
                                rs.getInt("Manager_phone"),
                                rs.getDate("Manager_BOB"),
                                rs.getString("Manager_Gender"),
                                rs.getString("Manage_Email"),
                                rs.getDouble("Manage_Salary"),
                                rs.getInt("address_ID")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");

            dataList = FXCollections.observableArrayList(data);

            myDataTable.setItems((ObservableList<Manager>) dataList);

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
