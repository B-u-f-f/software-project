package software.web.signup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

public class FarmerSignUpDao extends DatabaseConstants {

    /**
    * This is a function that is used to get the details of the farmer and then we can put the details in the MYSQL Server.
    * @param email
    *     This String contains the email of the farmer.
    * @param phoneNum
    *     This String contains the phone number of the farmer.
    * @param pass
    *     This String contains the password of the farmer.
    * @param fname
    *     This String contains the first name of the farmer.
    * @param lname
    *     This String contains the last name of the farmer.
    * @param acc_creation_date
    *     This String contains the date of the creationg of the farmer's account.
    * @param address
    *     This String contains the address of the farmer.
    * @return 
    *     This returns void.
    **/
    public void putToFarmerDB(String email, String phoneNum, String pass, String fname, String lname, String acc_creation_date, String address){

        String sqlStmt = "INSERT INTO FarmerAccount VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        
        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, email);
            st.setString(2, phoneNum);
            st.setString(3, pass);
            st.setString(4, fname);
            st.setString(5, lname);
            st.setString(6, acc_creation_date);
            st.setString(7, address);

            st.executeUpdate();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}