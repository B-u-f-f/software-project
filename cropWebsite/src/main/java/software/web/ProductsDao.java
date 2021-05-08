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

public class ProductsDao extends DatabaseConstants {
    private Connection con;

    public ProductsDao() {

        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

//SELECT COUNT(CropID)
//FROM Crop;

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

    protected void finalize() throws Throwable {
        con.close();
    } 

}