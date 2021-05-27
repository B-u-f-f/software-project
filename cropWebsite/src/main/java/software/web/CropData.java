package software.web.index.database;

 /**
* The CropDat retrives the products stored in the database and displays them in multiple pages 
* The User can navigate through these pages and is also given the option to sort the products based on the price or rating.
*
* @author  Ritwik Sinha
* @version 1.0
*/

public class CropData {
    private String cropID;
    private String imageURI;
    private String cropName;
    private int price;
    private int rating;
    private int quantity;

    /**
    * This is a constructor that is used to set the cropID, cropname and price.
    * @param cropID
    *     This is a String parameter to set the cropID.
    * @param cropName
    *     This is a String parameter to set the cropName.
    * @param price
    *     This is a int parameter to set the price of the crop.
    */
    public CropData(String cropID, String cropName, int price){
        this.cropID = cropID;
        this.cropName = cropName;
        if(price < 0) this.price = 0;
        else this.price = price;
        this.quantity = 0;
    }

    /**
    * This is a constructor that is used to set the cropID, cropname, price, imageURI and rating.
    * @param cropID
    *     This is a String parameter to set the cropID.
    * @param cropName
    *     This is a String parameter to set the cropName.
    * @param imageURI
    *     This is a String parameter to set the image of the crop.
    * @param price
    *     This is a int parameter to set the price of the crop.
    * @param rating
    *     This is a int parameter to set the rating of the crop.
    */
    public CropData(String cropID, String cropName, String imageURI, int price, int rating){
        this.cropID = cropID;
        this.cropName = cropName;
        this.imageURI = imageURI;
        if(price < 0) this.price = 0;
        else this.price = price;
        this.rating = rating;
        this.quantity = 0;
    }

    /**
    * This is a method that is used to get the quantity.
    * @param void
    *     The parameter is void.
    * @return
    *     An int is returned that contains the quantity.
    */
    public int getQuantity(){return quantity;}

    /**
    * This is a method that is used to set the quantity.
    * @param quantity
    *     The parameter is an integer quantity.
    * @return
    *     This returns void
    */
    public void setQuantity(int quantity){ this.quantity=quantity;}

    /**
    * This is a static method that is used return empty CropData object.
    * @param void
    *     The parameter is void.
    * @return
    *     A CropData object is returned which contains empty data fields.
    */
    public static CropData returnEmptyCropData(){
        CropData obj = new CropData("", "", "", 0, 0);
        return obj;
    }

    /**
    * This is a method that is used to get the cropID.
    * @param void
    *     The parameter is void.
    * @return
    *     A String is returned that contains the cropID.
    */
    public String getCropID() { return cropID; }

    /**
    * This is a method that is used to get the cropName.
    * @param void
    *     The parameter is void.
    * @return
    *     A String is returned that contains the cropName.
    */
    public String getCropName() { return cropName; }

    /**
    * This is a method that is used to get the price.
    * @param void
    *     The parameter is void.
    * @return
    *     An int is returned that contains the price.
    */
    public int getPrice() { return price; }
    
    /**
    * This is a method that is used to get the image of the Crop.
    * @param quantity
    *     The parameter void.
    * @return
    *     This returns a String that contains the image uri.
    */
    public String getImageURI() { return imageURI; }
        public void setImageURI(String imageURI){
        this.imageURI = imageURI;
    } 

    /**
    * This is a method that is used to get the rating.
    * @param void
    *     The parameter is void.
    * @return
    *     An int is returned that contains the rating.
    */
    public int getRating() { return rating; }

    /**
    * This is a method that is used to set the rating of the crop.
    * @param rating
    *     The parameter is an integer rating.
    * @return
    *     This returns void
    */
    public void setRating(int rating){
        if(rating > 5) rating = 5;
        else if(rating < 0) rating = 0;
        else this.rating = rating;
    }

    /**
    * This is a method that is used to print all the data in the CropData Object.
    * @param void
    *     The parameter is void
    * @return
    *     This returns a String that contains all the data in the object.
    */
    @Override
    public String toString(){
        return "CropID: " + cropID + ", " + "CropName: " + cropName + ", "
        + "ImageURI: " + imageURI + ", " + "Price: " + Integer.toString(price);
    }
}