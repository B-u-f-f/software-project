package software.web.products.database;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;

 /**
* The ProductsDao has all the functions that serve to manipulate the database. 
* It retrives the products stored in the database by first establishing the connection with Database.
* The products are retrieved with a SELECT query to the CROP table in the database.
* This code is also responsible for finding out the page where a particular product will be displayed.
*
* @author  Ritwik Sinha
* @version 1.0
*/

public class ProductsDao extends DatabaseConstants {
    private Connection con;

    /**
    * This is a constructor which will open the required connection to the MYSQL Database.
    * @param void
    *     This is no parameter in this method.
    */
    public ProductsDao() {

        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
    * This method is used to get the the Product Data from the MYSQL Database.
    * @param void
    *     There is no parameter in this function.
    * @return 
    *     The function is returning a ArrayList<ProductData> which contains the ProductData object.
    */
    private ArrayList<ProductData> getProductData(){
        String sqlStmt = "SELECT CropID, CropName, Price FROM Crop;";
        String cropID, cropName;
        int price;

        ArrayList<ProductData> result = new ArrayList<ProductData>();

        try {

            PreparedStatement st = con.prepareStatement(sqlStmt);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                cropID = rs.getString("CropID");
                cropName = rs.getString("CropName");
                price = rs.getInt("Price");

                result.add(new ProductData(cropID, cropName, "", "", 0, price));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    /**
    * This method is used to get the image of the crop according to the cropID provided from the MYSQL Database.
    * @param cropID
    *     This is the ID of the crop for which we want the crop image urls.
    * @return
    *     The function is returning ArrayList<String> containing the crop image urls.
    */
    private ArrayList<String> getProductImage(String cropID) {
        String sqlStmt = "SELECT Images FROM CropImages WHERE CropID = ? LIMIT  1;";

        ArrayList<String> result = new ArrayList<String>();

        try {
            
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, cropID);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                result.add(rs.getString("Images"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
            
    }
    
    /**
    * This method is used to get the category of the crop according to the cropID provided from the MYSQL Database. 
    * @param cropID
    *     This is the ID of the crop for which we want the crop category.
    * @return
    *     The function is returning ArrayList<String> conataining the crop categories.
    */
    private ArrayList<String> getProductCategories(String cropID){
        String sqlStmt = "SELECT Category FROM CropCategory WHERE CropID = ?;";

        ArrayList<String> result = new ArrayList<String>();

        try {
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, cropID);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                result.add(rs.getString("Category"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    /**
    * This method is used to get the total number of crop present in the MYSQL Database.
    * @param void
    *     This is no parameter in this method.
    * @return 
    *     The function returns a int which contains the total count.
    */
    public int getTotalProductLength() {
        String sqlStmt = "SELECT COUNT(CropID) AS totalCount FROM Crop;";

        try {   
            PreparedStatement st = con.prepareStatement(sqlStmt);
            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                return rs.getInt("totalCount");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    /**
    * This method is used to get the Product Data array of the crop according to the page number and per page quantity provided from the MYSQL Database.   
    * @param pageNum
    *     This is a int value that tells the page number.
    * @param perPage
    *     This is a int value that tells how many products are there for each page.
    * @return 
    *     The function is returning a ProductData array.
    */
    public ProductData[] getAllProductData(int pageNum, int perPage){
        ArrayList<ProductData> products = getProductData();
        for(ProductData product : products){
            product.setImages(getProductImage(product.getCropID()));
            product.addCategories(getProductCategories(product.getCropID()));
        }

        int firstp = (pageNum - 1) * perPage;
        firstp = (firstp + 1) > products.size() ? 0 : firstp; //3

        int lastp = firstp + perPage; //6
        lastp = lastp > products.size() ? products.size() : lastp; //6

        ProductData[] pd = new ProductData[lastp - firstp];

        for(int i = firstp; i < lastp; i++){
            pd[i - firstp] = products.get(i);
        }

        return pd;
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