package software.web.signup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Project import
import software.web.database.DatabaseConstants;

public class CustomerSignUpDao extends DatabaseConstants{

    public void putToCustomerDB(String email, String phoneNo, String pass) {
        
        String sqlStmt = "INSERT INTO CustomerAccount VALUES (?, ?, ?);";
        String sqlStmt1 = "INSERT INTO Cart VALUES (?, 0, 0)";
       
        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, email);
		    st.setString(2, pass);
            st.setString(3, phoneNo);
            st.executeUpdate();

            st = con.prepareStatement(sqlStmt1);
            st.setString(1, email);
            st.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }

}