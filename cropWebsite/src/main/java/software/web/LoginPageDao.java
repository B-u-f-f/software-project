package software.web.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

public class LoginPageDao extends DatabaseConstants{

    public boolean check(String email, String pass) {
        // String sql = "SELECT * FROM (SELECT EmailID, PasswordHash FROM FarmerAccount UNION SELECT EmailID, PasswordHash FROM CustomerAccount) AS EmailPassword WHERE EmailID = ? AND PasswordHash = ?;";

        String sql = "SELECT EmailID, PasswordHash FROM CustomerAccount WHERE EmailID = ? AND PasswordHash = ?;";

        
        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return true;
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        
        return false;	
	}
}