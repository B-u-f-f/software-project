package software.web.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

public class LoginPageDao extends DatabaseConstants{
    Connection con;
    public LoginPageDao(){
        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String check(String email, String pass) {
        // String sql = "SELECT * FROM (SELECT EmailID, PasswordHash FROM FarmerAccount UNION SELECT EmailID, PasswordHash FROM CustomerAccount) AS EmailPassword WHERE EmailID = ? AND PasswordHash = ?;";

        String sqlCus = "SELECT EmailID, PasswordHash FROM CustomerAccount WHERE EmailID = ? AND PasswordHash = ?;";
        String sqlFar = "SELECT EmailID, PasswordHash FROM FarmerAccount WHERE EmailID = ? AND PasswordHash = ?;";
        
        try {
            PreparedStatement st = con.prepareStatement(sqlCus);
            st.setString(1, email);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                return "Customer";
            }

            st = con.prepareStatement(sqlFar);
            st.setString(1, email);
            st.setString(2, pass);

            rs = st.executeQuery();
            if(rs.next()) {
                return "Farmer";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        
        return null;	
	}

    protected void finalize() throws Throwable {
        con.close();
    }
}