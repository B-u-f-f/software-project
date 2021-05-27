package software.web.cart.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

 /**
* The RemoveCartItem Dao is used to remove the products from a user's cart 
* This functionality is achieved by executing a DELETE query on the database and then UPDATING the user's cart
* @author  Ritwik Sinha
* @version 1.0

*/

public class RemoveCartItemDao extends DatabaseConstants {
    private Connection con;

    /**
    * This is a constructor that is used to open the connnection to the MYSQL Database.
    * @param void
    *     This is no parameter in this method.
    */
    public RemoveCartItemDao() {
        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * This method is used to remove the crop item from the cart of the customer and modify the MYSQL Database accordingly.
    * @param cropID
    *     This is a String parameter to take in the cropID in order to remove from cart.
    * @param emailID
    *     This is String parameter to  take in the emailID of the customer from whose cart we are removing. 
    * @return 
    *     The function returns void.
    */
    public void removeItemCart(String cropID, String emailID) {
        String sqlStmt = "DELETE FROM `Contains` WHERE CropID = ? AND EmailID = ?;";

        String sqlStmtUpd = "UPDATE Cart SET ItemQuantity = IFNULL((SELECT COUNT(c.EmailID) FROM `Contains` c INNER JOIN Crop c2 ON c.CropID = c2.CropID WHERE c.EmailID = ? GROUP BY c.EmailID), 0), TotalPrice = IFNULL((SELECT SUM(c.ProductQuantity * c2.Price) FROM `Contains` c INNER JOIN Crop c2 ON c.CropID = c2.CropID WHERE c.EmailID = ?), 0) WHERE EmailID = ?;";

        try {
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, cropID);
            st.setString(2, emailID);
            st.executeUpdate();

            st = con.prepareStatement(sqlStmtUpd);
            st.setString(1, emailID);
            st.setString(2, emailID);
            st.setString(3, emailID);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
    * This method is used to close the connection that we opened in the constructor.
    * @param void
    *     This is no parameter in this method.
    * @return 
    *     The function returns void.
    */
    protected void finalize() throws Throwable {
        con.close();
    } 
}