package software.web.cart.database;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;
import software.web.index.database.CropData;


public class CartDao extends DatabaseConstants {
    private Connection con;

    /**
    * This is a constructor that is used to open the connnection to the MYSQL Database.
    * @param void
    *     There is no parameter in this method.
    */
    public CartDao() {
        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * This is a function that is used to get the name and price of the crop in the customer's cart from MYSQL Database.
    * @param email
    *     There is a String email to get the crop in the cart of the customer.
    * @return 
    *     It returns a ArrayList<CropData> which contains all the crops in the customer's cart.
    **/
    private ArrayList<CropData> getCartNamePrice(String email) {
        String sqlStmt = "SELECT c.CropID , c.CropName , c.Price , c2.ProductQuantity FROM Crop c INNER JOIN `Contains` c2  ON c.CropID  = c2.CropID INNER JOIN Cart c3 ON c2.EmailID = c3.EmailID  INNER JOIN CustomerAccount ca ON c3.EmailID = ca.EmailID WHERE ca.EmailID = ?;";

        ArrayList<CropData> result = new ArrayList<CropData>();
        
        String cropName, cropID;
        int price, quantity;

        try{    
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                cropName = rs.getString("CropName");
                cropID = rs.getString("CropID");
                price = rs.getInt("Price");
                quantity = rs.getInt("ProductQuantity");
                
                CropData cd = new CropData(cropID, cropName, price);
                cd.setQuantity(quantity);

                result.add(cd);                
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return result;
        
    }

    /**
    * This is a function that is used to get the image url of the crop which is in the customer's cart.
    * @param cropID
    *     There is a String cropID of the particular crop which is in customer's cart.
    * @return 
    *     A string is returned which contains the url of the crop.
    **/
    private String getCartImage(String CropID){
        String sqlStmt = "SELECT Images FROM CropImages WHERE CropID = ?;";

        try{
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, CropID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getString("Images");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return "https://bitsofco.de/content/images/2018/12/Screenshot-2018-12-16-at-21.06.29.png";
        
    }

    /**
    * This method is used to get the details of all the crops in the form of List of the specified customer from the MYSQL Database.
    * @param email
    *     There is a String email of the Customer whose cart we have to update in the MYSQL Database.
    * @return 
    *     A ArrayList<CropData> is returned which contains the CropData object of the crops that the customer has selected.
    **/
    public ArrayList<CropData> getCartData(String email){
        
        ArrayList<CropData> result = getCartNamePrice(email);

        for(CropData c: result) {
            c.setImageURI(getCartImage(c.getCropID()));
        }
        
        return result;
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