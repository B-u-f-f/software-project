package software.web.signup.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Project import
import software.web.database.DatabaseConstants;

 /**
* The CustomerSignUpDao uses putCustomerDB method to insert customer data to the database tables(CustomerAccount and Cart)
*
* @author  Ritwik Sinha
* @version 1.0
*/

public class CustomerSignUpDao extends DatabaseConstants{

    /**
    * This is a function that is used to put the customer sign up data in the MYSQL Database so that the customer can login later.
    * @param email
    *     There is a String email of the particular customer.
    * @param phoneNo
    *     There is a String phoneNo of the customer.
    * @param pass
    *     There is the String password of the customer.
    * @return 
    *     This returns void.
    **/
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