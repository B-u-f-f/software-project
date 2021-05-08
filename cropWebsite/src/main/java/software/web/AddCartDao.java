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

public class AddCartDao extends DatabaseConstants{
    private Connection con;



    public AddCartDao(){
        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
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
    
    protected void finalize() throws Throwable {
        con.close();
    }

}