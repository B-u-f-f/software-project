package software.web.products.database;

import java.util.ArrayList;

//CropName, MaxQuantity , ProductionDate , ExpirationDate , Price 

public class ProductData {
    private String cropName;
    private String productionDate;
    private String expirationDate;

    private int maxQuantity;
    private int price;

    ArrayList<String> images;
    ArrayList<Category> categories;

    public ProductData(String cropName, 
                      String productionDate, 
                      String expirationDate,
                      int maxQuantity,
                      int price){
        
        this.cropName = cropName; 
        this.productionDate = productionDate; 
        this.expirationDate = expirationDate;
        this.maxQuantity = maxQuantity;
        this.price = price;  
        images = new ArrayList<String>();
        categories = new ArrayList<Category>();
    }

    public static ProductData getEmptyProductData() {
        return new ProductData("", "", "", 0, 0);
    }

    public String getCropName() { return cropName; }
    public String getProductionDate() { return productionDate; }
    public String getExpirationDate() { return expirationDate; }
    public int getMaxQuantity() { return maxQuantity; }
    public int getPrice() { return price; }

    public ArrayList<String> getImages() { return images; }
    
    public void setImages(ArrayList<String> images){
        this.images = images;
    }

    public ArrayList<Category> getCategories() { return categories; }
    public void addCategories(ArrayList<String> categories){
        for(String c : categories){
            this.categories.add(Category.createCategory(c));
        }
    }

}