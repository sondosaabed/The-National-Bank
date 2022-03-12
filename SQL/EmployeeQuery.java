package SQL;

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
import Sample.Employee;
import sqlStyle.choice;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/* 
    This class is used to make an employee query including (delete, insert, update, search)
*/
public class EmployeeQuery {    
	public ObservableList<Employee> dataList;
    public  ArrayList<Employee> data = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();

    @SuppressWarnings("unchecked")
	public void tableView(Stage stage, GridPane pane) {
        TableView<Employee> myDataTable = new TableView<Employee>();

        Scene scene = new Scene(pane);
        stage.setTitle("Employee Table");

        TableColumn<Employee, Integer> id = new TableColumn<Employee, Integer>("Number");
        id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeID"));

        TableColumn<Employee, String> nameCol = new TableColumn<Employee, String>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));

        TableColumn<Employee, String> genderCol = new TableColumn<Employee, String>("Gender");
        genderCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeGender"));

        TableColumn<Employee, Date> DOBCol = new TableColumn<Employee,Date>("DOB");
        DOBCol.setCellValueFactory(new PropertyValueFactory<Employee, Date>("employeeDOB"));

        TableColumn<Employee, String> email = new TableColumn<Employee, String>("Email");
        email.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeEmail"));

        TableColumn<Employee, Double> employeeSalary = new TableColumn<Employee, Double>("Salary");
        employeeSalary.setCellValueFactory(new PropertyValueFactory<Employee, Double>("employeeSalary"));

        TableColumn<Employee, Integer> departmentID = new TableColumn<Employee, Integer>("department ID");
        departmentID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("departmentID"));

        TableColumn<Employee, Integer> address = new TableColumn<Employee, Integer>("address");
        address.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("address"));

        TableColumn<Employee, Integer> phoneCol = new TableColumn<Employee, Integer>("Phone");
        phoneCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeePhone"));

        myDataTable.setItems(dataList);
        myDataTable.getColumns().addAll(id, nameCol ,phoneCol,genderCol,DOBCol,email,employeeSalary,departmentID,address);
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

    public ObservableList<Employee> getDataList() {
        return dataList;
    }

    public void setDataList(ObservableList<Employee> dataList) {
        this.dataList = dataList;
    }

    private void getEmployeeData() throws SQLException, ClassNotFoundException {
        String SQL;
        connectionTOSQL.connect();

        System.out.println("Connection established");

        SQL = "select * from employee";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )
            data.add(new Employee(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    Integer.parseInt(rs.getString(3)),
                    rs.getString(4),
                    Date.valueOf(rs.getString(5)),
                    rs.getString(6),
                    Double.parseDouble(rs.getString(7)),
                    Integer.parseInt(rs.getString(8)),
                    Integer.parseInt(rs.getString(9))));
        rs.close();
        stmt.close();
        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
   }
    
    public void getData() throws SQLException, ClassNotFoundException {
        getEmployeeData();
    }

    public void insertData(Employee rc) {
        try {
            connectionTOSQL.connect();
            connectionTOSQL.ExecuteStatement("Insert into employee (employee_name, employee_phone, employee_gender, employee_DOB, employee_Email, employee_Salary, Department_ID, address_ID) values('" +rc.getEmployeeName()+"'," + rc.getEmployeePhone() +",'" + rc.getEmployeeGender() +"','" + rc.getEmployeeDOB() +"','" + rc.getEmployeeEmail()+"'," + rc.getEmployeeSalary()+"," + rc.getDepartmentID()+"," + rc.getAddress()+");");
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
            comboBox.getItems().add(data.get(i).getEmployeeID()+"");
        }
    }

    public String update(ArrayList<choice> conditions, ArrayList<choice> choices) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Update Employee SET ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<choices.size();i++) {
	                if(i==choices.size()-1) {
	                    if (choices.get(i).getType() == "employee_name" || choices.get(i).getType() == "employee_Email" || choices.get(i).getType() == "employee_gender" || choices.get(i).getType() == "employee_DOB") {
	                        sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(choices.get(i).getType() + " = "  + choices.get(i).getValue());
	                    }
	                    break;
	                }
	                if (choices.get(i).getType() == "employee_name" || choices.get(i).getType() == "employee_Email" || choices.get(i).getType() == "employee_gender" || choices.get(i).getType() == "employee_DOB") {
	                    sql = sql.concat(choices.get(i).getType() + " = " + "'" + choices.get(i).getValue() + "'" + ", ");
	                }else{
	                    sql= sql.concat(choices.get(i).getType() +" = " +choices.get(i).getValue()+ ", ");
	                }
	            }
	            
	            sql = sql.concat(" Where ");
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "employee_name" || conditions.get(i).getType() == "employee_Email" || conditions.get(i).getType() == "employee_gender" || conditions.get(i).getType() == "employee_DOB") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "employee_name" || conditions.get(i).getType() == "employee_Email" || conditions.get(i).getType() == "employee_gender" || conditions.get(i).getType() == "employee_DOB") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="Employee Updated";
	            } else {
	                answer ="Employee not updated";
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

    public String delete(ArrayList<choice> conditions) {
        String answer ="";
        String search = search(conditions);
        if(search=="Found"){
	        try {
	            String sql="Delete from Employee Where ";
	
	            connectionTOSQL.connect();
	            for(int i =0; i<conditions.size();i++) {
	                if(i==conditions.size()-1) {
	                    if (conditions.get(i).getType() == "employee_name" || conditions.get(i).getType() == "employee_Email" || conditions.get(i).getType() == "employee_gender" || conditions.get(i).getType() == "employee_DOB") {
	                        sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'");
	                    }else{
	                        sql = sql.concat(conditions.get(i).getType() + " = "  + conditions.get(i).getValue());
	                    }
	                    break;
	                }
	                if (conditions.get(i).getType() == "employee_name" || conditions.get(i).getType() == "employee_Email" || conditions.get(i).getType() == "employee_gender" || conditions.get(i).getType() == "employee_DOB") {
	                    sql = sql.concat(conditions.get(i).getType() + " = " + "'" + conditions.get(i).getValue() + "'" + " AND ");
	                }else{
	                    sql= sql.concat(conditions.get(i).getType() +" = " +conditions.get(i).getValue()+ " AND ");
	                }
	            }
	            boolean ans = connectionTOSQL.ExecuteStatement(sql+";");
	            if(ans== true) {
	                answer ="Employee Deleted";
	            } else {
	                answer ="Employee not Deleted";
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

	public String search(ArrayList<choice> conditions,ArrayList<choice> show, GridPane pane5, int i, int j) {
        ObservableList<Employee> dataList = null ;
        TableView<Employee> myDataTable = new TableView<Employee>();
        ArrayList<Employee> data = new ArrayList<>();
        
    	String answer="";
    	try {
            String sql="Select *";
            connectionTOSQL.connect();
            
    		for(int i2 =0; i2<show.size();i2++) {

	    		if(show.get(i2).getType() == "employee_name") {
	    	        TableColumn<Employee, String> nameCol = new TableColumn<Employee, String>("Name");
	    	        nameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeName"));
	                myDataTable.getColumns().add(nameCol);
	    		} else if(show.get(i2).getType() == "employee_Email") {
	    	        TableColumn<Employee, String> email = new TableColumn<Employee, String>("Email");
	    	        email.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeEmail"));
	                myDataTable.getColumns().add(email);
	    		}else if(show.get(i2).getType() == "employee_gender") {
	    	        TableColumn<Employee, String> genderCol = new TableColumn<Employee, String>("Gender");
	    	        genderCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeGender"));
	                myDataTable.getColumns().add(genderCol);
	    		}else if(show.get(i2).getType() == "employee_DOB") {
	    	        TableColumn<Employee, Date> DOBCol = new TableColumn<Employee,Date>("DOB");
	    	        DOBCol.setCellValueFactory(new PropertyValueFactory<Employee, Date>("employeeDOB"));
	                myDataTable.getColumns().add(DOBCol);
	    		}else if(show.get(i2).getType() == "employee_ID") {
	    	        TableColumn<Employee, Integer> id = new TableColumn<Employee, Integer>("Number");
	    	        id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeID"));
	                myDataTable.getColumns().add(id);
	    		}else if(show.get(i2).getType() == "employee_Salary") {
	    	        TableColumn<Employee, Double> employeeSalary = new TableColumn<Employee, Double>("Salary");
	    	        employeeSalary.setCellValueFactory(new PropertyValueFactory<Employee, Double>("employeeSalary"));
	                myDataTable.getColumns().add(employeeSalary);
	    		}else if(show.get(i2).getType() == "employee_phone") {
	    	        TableColumn<Employee, Integer> phoneCol = new TableColumn<Employee, Integer>("Phone");
	    	        phoneCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeePhone"));
	                myDataTable.getColumns().add(phoneCol);
	    		}else if(show.get(i2).getType() == "Department_ID") {
	    	        TableColumn<Employee, Integer> departmentID = new TableColumn<Employee, Integer>("department ID");
	    	        departmentID.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("departmentID"));
	                myDataTable.getColumns().add(departmentID);
	    		}else if(show.get(i2).getType() == "address_ID") {
	    	        TableColumn<Employee, Integer> address = new TableColumn<Employee, Integer>("address");
	    	        address.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("address"));
	                myDataTable.getColumns().add(address);
	    		}
	    	}
	    	sql= sql.concat(" From Employee Where ");
    		for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "employee_name" || conditions.get(i1).getType() == "employee_Email" || conditions.get(i1).getType() == "employee_gender" || conditions.get(i1).getType() == "employee_DOB") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "employee_name" || conditions.get(i1).getType() == "employee_Email" || conditions.get(i1).getType() == "employee_gender" || conditions.get(i1).getType() == "employee_DOB") {
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
                		new Employee(
                		        rs.getInt("employee_ID"),
                		        rs.getString("employee_name"),
                				rs.getInt("employee_phone"),
                				rs.getString("employee_gender"),
                                rs.getDate("employee_DOB"),
                                rs.getString("employee_Email"),
                                rs.getDouble("employee_Salary"),
                                rs.getInt("Department_ID"),
                                rs.getInt("address_ID")
                				)		
                 );
            rs.close();
            stmt.close();
	        connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            
            dataList = FXCollections.observableArrayList(data);

	        myDataTable.setItems((ObservableList<Employee>) dataList);
	    	
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
        ObservableList<Employee> dataList = null ;
        TableView<Employee> myDataTable = new TableView<Employee>();
        ArrayList<Employee> data = new ArrayList<>();

        String answer="";
        try {
            String sql="Select *";
            connectionTOSQL.connect();
            sql= sql.concat(" From Employee Where ");
            for(int i1 =0; i1<conditions.size();i1++) {
                if(i1==conditions.size()-1) {
                    if (conditions.get(i1).getType() == "employee_name" || conditions.get(i1).getType() == "employee_Email" || conditions.get(i1).getType() == "employee_gender" || conditions.get(i1).getType() == "employee_DOB") {
                        sql = sql.concat(conditions.get(i1).getType() + " = " + "'" + conditions.get(i1).getValue() + "'");
                    }else{
                        sql = sql.concat(conditions.get(i1).getType() + " = "  + conditions.get(i1).getValue());
                    }
                    break;
                }
                if (conditions.get(i1).getType() == "employee_name" || conditions.get(i1).getType() == "employee_Email" || conditions.get(i1).getType() == "employee_gender" || conditions.get(i1).getType() == "employee_DOB") {
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
                        new Employee(
                                rs.getInt("employee_ID"),
                                rs.getString("employee_name"),
                                rs.getInt("employee_phone"),
                                rs.getString("employee_gender"),
                                rs.getDate("employee_DOB"),
                                rs.getString("employee_Email"),
                                rs.getDouble("employee_Salary"),
                                rs.getInt("Department_ID"),
                                rs.getInt("address_ID")
                        )
                );
            rs.close();
            stmt.close();
            connectionTOSQL.getCon().close();
            System.out.println("Connection closed");
            dataList = FXCollections.observableArrayList(data);
            myDataTable.setItems((ObservableList<Employee>) dataList);

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

