package software.web.cart.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

/*
DELETE FROM `Contains` WHERE CropID = 'Crop123' AND EmailID = 'abc123@gmail.com';
*/

public class RemoveCartItemDao extends DatabaseConstants {
    private Connection con;

    public RemoveCartItemDao() {
        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeItemCart(String cropID, String emailID) {
        String sqlStmt = "DELETE FROM `Contains` WHERE CropID = ? AND EmailID = ?;";

        String sqlStmtUpd = "UPDATE Cart SET ItemQuantity = (SELECT COUNT(c.EmailID) FROM `Contains` c INNER JOIN Crop c2 ON c.CropID = c2.CropID WHERE c.EmailID = ? GROUP BY c.EmailID), TotalPrice = (SELECT SUM(c.ProductQuantity * c2.Price) FROM `Contains` c INNER JOIN Crop c2 ON c.CropID = c2.CropID WHERE c.EmailID = ?) WHERE EmailID = ?;";

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

    protected void finalize() throws Throwable {
        con.close();
    } 
}