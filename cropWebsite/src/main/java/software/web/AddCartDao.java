package software.web.cart.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

//Project imports
import software.web.database.DatabaseConstants;


 /**
* The AddCartDao inserts the products stored in the database and then runs an update query on the database 
* @author  Ritwik Sinha
* @version 1.0
*/

public class AddCartDao extends DatabaseConstants{
    private Connection con;


    /**
    * This is a constructor that is used to open the connnection to the MYSQL Database.
    * @param void
    *     There is no parameter in this method.
    */
    public AddCartDao(){
        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
    * This is a function that is used to put the crop items in the cart of the customer and update the MYSQL Database accordingly.
    * @param cropID
    *     There is a String cropID of the particular crop.
    * @param emailID
    *     There is a String emailID of the person in whose cart we have to add.
    * @param quantity
    *     There is int quantity that tells the number of crop that customer wants to buy.
    * @return 
    *     The function returns void.
    */
    public void putProductToCart(String cropID, String emailID, int quantity) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);

        String sqlStmt = "INSERT INTO `Contains` VALUES (?, ?, ?, ?);";
        //Change query error here
        String sqlUpdateStmt = 
        "UPDATE Cart SET ItemQuantity = (SELECT COUNT(c.EmailID) FROM `Contains` c INNER JOIN Crop c2 ON c.CropID = c2.CropID WHERE c.EmailID = ? GROUP BY c.EmailID), TotalPrice = (SELECT SUM(c.ProductQuantity * c2.Price) FROM `Contains` c INNER JOIN Crop c2 ON c.CropID = c2.CropID WHERE c.EmailID = ?) WHERE EmailID = ?;";
   
        try {
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, cropID);
            st.setString(2, strDate);
            st.setString(3, emailID);
            st.setInt(4, quantity);            
            st.executeUpdate();
            
            st = con.prepareStatement(sqlUpdateStmt);
            st.setString(1, emailID);
            st.setString(2, emailID);
            st.setString(3, emailID);
            st.executeUpdate();

        } catch (Exception e) {
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