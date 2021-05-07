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

/*

SELECT c.CropID , c.CropName , c.Price , c2.ProductQuantity 
FROM Crop c 
INNER JOIN `Contains` c2 
ON c.CropID  = c2.CropID 
INNER JOIN Cart c3 
ON c2.EmailID = c3.EmailID 
INNER JOIN CustomerAccount ca 
ON c3.EmailID = ca.EmailID
WHERE ca.EmailID = ?;

SELECT Images 
FROM CropImages
WHERE CropID = 'Crop123';

*/

public class CartDao extends DatabaseConstants {
    private Connection con;

    public CartDao() {
        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    public ArrayList<CropData> getCartData(String email){
        
        ArrayList<CropData> result = getCartNamePrice(email);

        for(CropData c: result) {
            c.setImageURI(getCartImage(c.getCropID()));
        }
        
        return result;
    }

    protected void finalize() throws Throwable {
        con.close();
    }
}