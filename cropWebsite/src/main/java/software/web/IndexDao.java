package software.web.index.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Project imports
import software.web.database.DatabaseConstants;

public class IndexDao extends DatabaseConstants {

    private ArrayList<CropData> getCropNamePrice() {
        String sqlStmt = "SELECT CropID, CropName, Price FROM Crop;";

        ArrayList<CropData> result = new ArrayList<CropData>();
        String cropID, cropName;
        int price;

        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            ResultSet rs = st.executeQuery();

            while(rs.next()) {

                cropID = rs.getString("CropID");
                cropName = rs.getString("CropName");
                price = rs.getInt("Price");

                result.add(new CropData(cropID, cropName, price));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Collections.shuffle(result);


        int n = result.size();
        for(int i = 8; i < n; i++) {
            result.remove(8);
        }
        return result;
    }

    private String getImageURI(String cropID) {
        String sqlStmt = "SELECT Images FROM CropImages WHERE CropID=?;";

        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, cropID);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                
                return rs.getString("Images");
            }
            con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }


        return "https://bitsofco.de/content/images/2018/12/Screenshot-2018-12-16-at-21.06.29.png"; // url of some "Not Found Error" image
    }

    public ArrayList<CropData> getCropData(){
        ArrayList<CropData> namePrice = getCropNamePrice();

        for(CropData c : namePrice){
            c.setImageURI(getImageURI(c.getCropID()));
            c.setRating(getRating(getCropCategory(c.getCropID())));
        }
        
        return namePrice;
    }

    private ArrayList<String> getCropCategory(String cropID) {
        String sqlStmt = "SELECT Category FROM CropCategory WHERE CropID = ?;";

        ArrayList<String> result = new ArrayList<String>();
        
     
        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, cropID);            
            ResultSet rs = st.executeQuery();

            while(rs.next()) {
                result.add(rs.getString("Category"));
            }

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }                
        return result;
    }

//R: number

    private int getRating(ArrayList<String> categories){
        for(String s: categories) {
            boolean b = Pattern.matches("^R: \\d$", s);
            if(b) {
                return Character.getNumericValue(s.charAt(3));
            }
        }
        return 0;
    }

    private ArrayList<CropData> getFeaturedProducts() {
        String sqlStmt = "SELECT c.CropID, c.CropName, c.Price FROM Crop c INNER JOIN CropCategory cc ON c.CropID = cc.CropID WHERE cc.Category = 'Featured';";

        ArrayList<CropData> result = new ArrayList<CropData>();

        try{

            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {

                String cropID = rs.getString("CropID");
                String cropName = rs.getString("CropName");
                int price = rs.getInt("Price");

                result.add(new CropData(cropID, cropName, price));
            }

            con.close();

        } catch(SQLException e) {
            e.printStackTrace();
        }

        Collections.shuffle(result);

        for(int i = 4; i < result.size(); i++) {
            result.remove(4);
        }

        return result;
    }

    public ArrayList<CropData> getFeaturedCropData() {
        ArrayList<CropData> featuredCrops = getFeaturedProducts();

        for(CropData c : featuredCrops){
            c.setImageURI(getImageURI(c.getCropID()));
            c.setRating(getRating(getCropCategory(c.getCropID())));
        }
        
        return featuredCrops;
    }

    public String[] getSeasonalCrop() {

        String sqlStmt = "SELECT DISTINCT c.CropID, c.CropName, ci.Images FROM Crop c INNER JOIN CropCategory cc ON c.CropID = cc.CropID  LEFT OUTER JOIN CropImages ci on c.CropID = ci.CropID WHERE cc.Category = ?;";

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String strDate = formatter.format(date);

        int month = Integer.parseInt(strDate);
        String seasonName;

        if(month >= 1 && month < 4) {
            seasonName = "S: Spring";
        } else if(month >= 4 && month <= 7) {
            seasonName = "S: Winter";
        } else if(month >= 8 && month <=10) {
            seasonName = "S: Summer";
        } else {
            seasonName = "S: Autumn";
        }

        String result[] = new String[3];

        try{
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, seasonName);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                result[0] = rs.getString("CropName");
                result[1] = rs.getString("Images");
                result[2] = rs.getString("CropID");
            } else {
                result[0] = result[1] = result[2] = "";
            }

            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return result;
    }
}