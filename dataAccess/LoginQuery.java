package dataAccess;

import java.io.IOException;
import java.sql.SQLException;

public class LoginQuery {
	DataBaseConnection con;

	public boolean login(String username, String password) throws IOException {
		boolean ans = false;
		try {
			String query = "SELECT * FROM login WHERE username = '" + username +"' AND passwd = SHA1("+password+");";
			con = new DataBaseConnection();
			ans=con.ExecuteSElect(query);

//            java.sql.Statement stmt = con.getCon().createStatement();
//	        ResultSet rs = stmt.executeQuery(query);

	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ans;
	}
}
