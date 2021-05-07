package software.web.products.database;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

/*
SELECT CropName, MaxQuantity , ProductionDate , ExpirationDate , Price 
FROM Crop 
WHERE CropID = 'Crop123';

*/

/*
SELECT Category
FROM CropCategory
WHERE CropID = '? AND Category != 'Featured';
 */

/*
SELECT Images 
FROM CropImages
WHERE CropID = 'Crop123'
*/


public class ProductDetailsDao extends DatabaseConstants {
    Connection con;


    public ProductDetailsDao(){
        try {   
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private ProductData getProductNameDate(String CropID) {
        String sqlStmt = "SELECT CropName, MaxQuantity , ProductionDate , ExpirationDate , Price FROM Crop WHERE CropID = ?;";

        String cropName, productionDate, expirationData;
        int maxQuantity, price;

        try {
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, CropID);
            ResultSet rs = st.executeQuery();

            if(rs.next()) {

                cropName = rs.getString("CropName");
                productionDate = rs.getString("ProductionDate");
                expirationData = rs.getString("ExpirationDate");
                maxQuantity = rs.getInt("MaxQuantity");
                price = rs.getInt("Price");

                return new ProductData(cropName, productionDate, expirationData, maxQuantity, price);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    
        return ProductData.getEmptyProductData();
    }

    protected void finalize() throws Throwable {
        con.close();
    }

    private ArrayList<String> getProductImages(String CropID) {

        String sqlStmt = "SELECT Images FROM CropImages WHERE CropID = ?;";

        ArrayList<String> result = new ArrayList<String>();
        try{
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1,CropID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                result.add(rs.getString("Images"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        if(result.size() == 0)
            result.add("https://bitsofco.de/content/images/2018/12/Screenshot-2018-12-16-at-21.06.29.png");

        return result;
    } 

    private ArrayList<String> getCategory(String CropID){
        String sqlStmt = "SELECT Category FROM CropCategory WHERE CropID =? AND Category != 'Featured';";

        ArrayList<String> result = new ArrayList<String>();
        
        try {
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1,CropID);
            
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                result.add(rs.getString("Category"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    public ProductData getProductData(String cropID) {
        ProductData result = getProductNameDate(cropID);
        result.setImages(getProductImages(cropID));
        result.addCategories(getCategory(cropID));
        return result;
    }

}




























