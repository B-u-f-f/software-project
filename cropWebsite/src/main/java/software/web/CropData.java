package software.web.index.database;

public class CropData {
    private String cropID;
    private String imageURI;
    private String cropName;
    private int price;

    public CropData(String cropID, String cropName, int price){
        this.cropID = cropID;
        this.cropName = cropName;
        if(price < 0) this.price = 0;
        else this.price = price;
    }

    public CropData(String cropID, String cropName, String imageURI, int price){
        this.cropID = cropID;
        this.cropName = cropName;
        this.imageURI = imageURI;
        if(price < 0) this.price = 0;
        else this.price = price;
    }


    public String getCropID() { return cropID; }
    public String getCropName() { return cropName; }
    public String getImageURI() { return imageURI; }
    public void setImageURI(String imageURI){
        this.imageURI = imageURI;
    } 
    public int getPrice() { return price; }

    @Override
    public String toString(){
        return "CropID: " + cropID + ", " + "CropName: " + cropName + ", "
        + "ImageURI: " + imageURI + ", " + "Price: " + Integer.toString(price);
    }
}