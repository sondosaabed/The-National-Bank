package SQL;

import javafx.scene.control.ComboBox;
import Sample.Branch;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/*
    This class is used to make an branch query
*/

public class BranchQuery {
        public ArrayList<Branch> data = new ArrayList<>();
        DataBaseConnection connectionTOSQL = new DataBaseConnection();

        private void getDataForDepartment() throws SQLException, ClassNotFoundException {

            String SQL;

            connectionTOSQL.connect();
            System.out.println("Connection established");
            SQL = "select Branch_ID from branch;";
            Statement stmt = connectionTOSQL.getCon().createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            while ( rs.next() )
                data.add(new Branch(
                        Integer.parseInt(rs.getString(1))));
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
                comboBox.getItems().add(data.get(i).getBranchId()+"");
            }
        }


    }
