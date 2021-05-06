package software.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

public class customerSignUpDao extends DatabaseConstants{


    public void putToCustomerDB(String email, int phoneNo, String pass) {
        
        String sqlStmt = "INSERT INTO CustomerAccount VALUES ('?', ?, '?')";
        
        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, email);
		    st.setInt(2, phoneNo);
            st.setString(3, pass);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
            
    }

}