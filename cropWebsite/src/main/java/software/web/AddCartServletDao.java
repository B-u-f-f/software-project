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
* The AddCartServletDao first establishes a connection with the database.
* It has a method putProductToCart that is called by other like ProductDetailsDao etc
*
* @author  Ritwik Sinha
* @version 1.0
*/

public class AddCartServletDao extends DatabaseConstants{
    private Connection con;


    /**
    * This is a constructor that is used to open the connnection to the MYSQL Database.
    * @param void
    *     There is no parameter in this method.
    */
    public AddCartServletDao(){
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
    *     
    **/
    public void putProductToCart(String cropID, String emailID, int quantity) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);

        String sqlStmt = "INSERT INTO `Contains` VALUES (?, ?, ?, ?);";
        String sqlUpdateStmt = "UPDATE Cart SET ItemQuantity = ItemQuantity + 1, TotalPrice = (SELECT c.ProductQuantity * c2.Price FROM `Contains` c INNER JOIN Crop c2 ON c.CropID = c2.CropID WHERE c.EmailID = ?) WHERE EmailID = ?;";
        
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
            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    

}