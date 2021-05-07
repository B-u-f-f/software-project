package software.web.index.database;

import java.util.ArrayList;
import java.util.Collections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Project imports
import software.web.database.DatabaseConstants;


/*
SELECT CropID, CropName, Price FROM Crop;

SELECT Images FROM CropImages WHERE CropID = ?;
*/ 

public class IndexDao extends DatabaseConstants {

    public ArrayList<CropData> getCropNamePrice() {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Collections.shuffle(result);

        for(int i = 8; i < result.size(); i++) {
            result.remove(8);
        }
        
        return result;
    }

    public String getImageURI(String cropID) {
        String sqlStmt = "SELECT Images FROM CropImages WHERE CropID=?";

        try {
            Connection con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
            PreparedStatement st = con.prepareStatement(sqlStmt);
            st.setString(1, cropID);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                return rs.getString("Images");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }


        return ""; // url of some "Not Found Error" image
    }

    public ArrayList<CropData> getCropData(){
        ArrayList<CropData> namePrice = getCropNamePrice();

        for(CropData c : namePrice){
            c.setImageURI(getImageURI(c.getCropID()));
        }
    
        
        return namePrice;
    }

}