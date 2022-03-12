package SQL;

import javafx.scene.control.ComboBox;
import Sample.Department;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/* 
    This class is used to make an department query
*/

public class DepartmentQuery {
    public ArrayList<Department> data = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();

    private void getDataForDepartment() throws SQLException, ClassNotFoundException {

        String SQL;

        connectionTOSQL.connect();
        System.out.println("Connection established");
        SQL = "select * from department;";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )
            data.add(new Department(
                    Integer.parseInt(rs.getString(1)),
                    rs.getString(2),
                    Integer.parseInt(rs.getString(3)),
                    rs.getString(4),
                    Integer.parseInt(rs.getString(5)),
                    Integer.parseInt(rs.getString(6))));
                    rs.close();
        stmt.close();

        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());


    }
    public void getData() throws SQLException, ClassNotFoundException {
        getDataForDepartment();
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
            comboBox.getItems().add(data.get(i).getDepartmentID()+"");
        }
    }


}
