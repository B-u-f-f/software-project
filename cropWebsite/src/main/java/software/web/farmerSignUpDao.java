package software.web.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

public class farmerSignUpDao extends DatabaseConstants {


    public void putToFarmerDB(String email, int phoneNum, String pass, String fname, String lname, String acc_creation_date, String address) {

        String sqlStmt = "INSERT INTO FarmerAccount VALUES ('?', ?, '?', '?', '?', '?', '?')";

        try {

            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, email);
            st.setInt(2, phoneNum);
            st.setString(3, fname);
            st.setString(4, lname);
            st.setString(5, acc_creation_date);
            st.setString(6, address);

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}