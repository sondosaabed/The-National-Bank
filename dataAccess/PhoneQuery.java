package dataAccess;

import java.sql.SQLException;
/* 
    This class is used to make a phone query
*/

import application.Phone;

public class PhoneQuery {
    DataBaseConnection connectionTOSQL = new DataBaseConnection();
    public void insertData(Phone rc) {

        try {
            connectionTOSQL.connect();

            connectionTOSQL.ExecuteStatement("Insert into phone (phone_number) values("
                    + rc.getPhoneNumber()+");");
            connectionTOSQL.getCon().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
