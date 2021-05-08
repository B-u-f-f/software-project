package software.web.farmercrop.database;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
SELECT CurrentCropIDNumber from CropIDNumber;
UPDATE CropIDNumber SET CurrentCropIDNumber = CurrentCropIDNumber + 1;


INSERT INTO Crop VALUES (ID, Name, quantity, ExpirationDate, ProductionDate, Price);

INSERT INTO CropImages (Images, CropID);

INSERT INTO CropCategory (Category, CropID);

INSERT INTO Sells (email, cropid, Quantity);
 */


//Project imports
import software.web.database.DatabaseConstants;

public class FarmerAddCropDao extends DatabaseConstants{
    private Connection con;

    public FarmerAddCropDao(){
        try {
            con = DriverManager.getConnection(DatabaseConstants.getUrl(), DatabaseConstants.getUsername(), DatabaseConstants.getPassword());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void addCrop(String cropName, int quantity, String productionDate , String expirationDate , int price, 
                        String cropType , String season, ArrayList<String> imgURLs, String email){
                            
        String sqlStmt = "SELECT CurrentCropIDNumber from CropIDNumber;";
        String sqlUpdateStmt = "UPDATE CropIDNumber SET CurrentCropIDNumber = CurrentCropIDNumber + 1" ;
        String sqlImgIns = "INSERT INTO CropImages VALUES (?, ?);";
        String sqlCcins="INSERT INTO CropCategory VALUES (?, ?);";
        String sqlSellsins="INSERT INTO Sells VALUES (?, ?, ?);";
        String sqlCropins= "INSERT INTO Crop VALUES (?, ?, ?, ?, ?, ?);";

        String cropID;
        try {
            PreparedStatement st = con.prepareStatement(sqlStmt);
            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                int id = rs.getInt("CurrentCropIDNumber");
                cropID = "Crop" + Integer.toString(id);
            }else {
                return;
            }

            st = con.prepareStatement(sqlUpdateStmt);
            st.executeUpdate();

            // insert into Crop
            st = con.prepareStatement(sqlCropins);
            st.setString(1, cropID);
            st.setString(2, cropName);
            st.setInt(3, quantity);
            st.setString(4, expirationDate);
            st.setString(5, productionDate);
            st.setInt(6, price);
            st.executeUpdate();
            
            //imageURLs
            st = con.prepareStatement(sqlImgIns);
            for(int i = 0; i < imgURLs.size(); i++) {
                st.setString(1, imgURLs.get(i));
                st.setString(2, cropID);
                st.executeUpdate();
            }

            //Category
            st = con.prepareStatement(sqlCcins);
            st.setString(1, "T: " + cropType);
            st.setString(2, cropID);
            st.executeUpdate();
    
            st = con.prepareStatement(sqlCcins);
            st.setString(1, "S: " + season);
            st.setString(2, cropID);
            st.executeUpdate();
            
            //Sells
            st = con.prepareStatement(sqlSellsins);
            st.setString(1, email);
            st.setString(2, cropID);
            st.setInt(3, quantity);
            st.executeUpdate();
            
          
            

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

     protected void finalize() throws Throwable {
        con.close();
    }
}