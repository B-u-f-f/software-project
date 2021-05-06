package software.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

public class loginSignUpDao extends DatabaseConstants{

    public boolean check(String email, String pass) {
        
        String sql = "select * from login where emailId=? and passwordHash=?";

        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return true;
            }		
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}
}