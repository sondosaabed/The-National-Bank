package dataAccess;

import javafx.scene.control.ComboBox;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.Address;

/*
    This class is used to make an address query
*/

public class AddressQuery {
    public ArrayList<Address> data = new ArrayList<>();
    DataBaseConnection connectionTOSQL = new DataBaseConnection();
    private void getDataForAddress() throws SQLException, ClassNotFoundException {
        String SQL;

        connectionTOSQL.connect();
        System.out.println("Connection established");
        SQL = "select * from address;";
        Statement stmt = connectionTOSQL.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(SQL);

        while ( rs.next() )
            data.add(new Address(
                    Integer.parseInt(rs.getString(1)),
                    Integer.parseInt(rs.getString(2)),
                    rs.getString(3),
                    rs.getString(4)));
        rs.close();
        stmt.close();

        connectionTOSQL.getCon().close();
        System.out.println("Connection closed" + data.size());
    }
    
    public void getData() throws SQLException, ClassNotFoundException {
        getDataForAddress();
    }

    public void insertData(Address rc) {

        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into address (Postal_code, Street_name, city_name) values("
                    +rc.getPostal_code()+",'"
                    +rc.getName()+"','"
                    + rc.getStreetName()+"');");
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
            comboBox.getItems().add(data.get(i).getPrimaryKey() + "," + data.get(i).getPostal_code() + "," + data.get(i).getName() + "," + data.get(i).getStreetName());
        }
    }


}
