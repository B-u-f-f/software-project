package software.web.index.database;

public class CropData {
    private String cropID;
    private String imageURI;
    private String cropName;
    private int price;
    private int rating;

    public CropData(String cropID, String cropName, int price){
        this.cropID = cropID;
        this.cropName = cropName;
        if(price < 0) this.price = 0;
        else this.price = price;
    }

    public CropData(String cropID, String cropName, String imageURI, int price, int rating){
        this.cropID = cropID;
        this.cropName = cropName;
        this.imageURI = imageURI;
        if(price < 0) this.price = 0;
        else this.price = price;
        this.rating = rating;
    }

    public static CropData returnEmptyCropData(){
        CropData obj = new CropData("", "", "", 0, 0);
        return obj;
    }

    public String getCropID() { return cropID; }
    public String getCropName() { return cropName; }
    public int getPrice() { return price; }
    
    public String getImageURI() { return imageURI; }
        public void setImageURI(String imageURI){
        this.imageURI = imageURI;
    } 
    
public int getRating() { return rating; }
    public void setRating(int rating){
        if(rating > 5) rating = 5;
        else if(rating < 0) rating = 0;
        else this.rating = rating;
    }

    @Override
    public String toString(){
        return "CropID: " + cropID + ", " + "CropName: " + cropName + ", "
        + "ImageURI: " + imageURI + ", " + "Price: " + Integer.toString(price);
    }
}