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

    /**
    * This is a constructor that is used to open the connnection to the MYSQL Database.
    * @param void
    *     This is no parameter in this method.
    */
    public ProductDetailsDao(){
        try {   
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
    * This method is used to get all the details of the crop whose cropID is given from the MYSQL Database.
    * @param cropID
    *     This is a String parameter to take in the cropID of the crop whose details we want.
    * @return 
    *     The function returns an object ProductData.
    */
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

                return new ProductData(CropID, cropName, productionDate, expirationData, maxQuantity, price);
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    
        return ProductData.getEmptyProductData();
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

    /**
    * This method is used to get all the images of the crop whose cropID is given from the MYSQL Database.
    * @param cropID
    *     This is a String parameter to take in the cropID of the crop whose images we want.
    * @return 
    *     The function returns an ArrayList<String> which contains the url of the image.
    */  
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

    /**
    * This method is used to get the category of the crop according to the cropID provided from the MYSQL Database. 
    * @param cropID
    *     This is the ID of the crop for which we want the crop category.
    * @return
    *     The function is returning ArrayList<String> conataining the crop categories.
    */
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

    /**
    * This method is used to get the product, images and the categories of the Crop and putting all of it in one object.
    * @param cropID
    *     This is the ID of the crop for which we want all the crop details.
    * @return
    *     The function is returning Product Data conataining the crop categories.
    */
    public ProductData getProductData(String cropID) {
        ProductData result = getProductNameDate(cropID);
        result.setImages(getProductImages(cropID));
        result.addCategories(getCategory(cropID));
        return result;
    }

}




























