package software.web.products.database;

import java.util.ArrayList;
import java.util.Arrays;

//CropName, MaxQuantity , ProductionDate , ExpirationDate , Price 


import java.util.Comparator;

class PriceComparator implements Comparator<ProductData> {
    public int compare(ProductData p1, ProductData p2){
        int pp1 = p1.getPrice();
        int pp2 = p2.getPrice();

        if(pp1 > pp2){
            return 1;
        }else if(pp2 > pp1){
            return -1;
        }else {
            return 0;
        }
    }
}

class RatingComparator implements Comparator<ProductData> {
    public int compare(ProductData p1, ProductData p2){
        int pp1 = p1.getRating();
        int pp2 = p2.getRating();

        if(pp1 > pp2){
            return -1;
        }else if(pp2 > pp1){
            return 1;
        }else {
            return 0;
        }
    }
}

public class ProductData {
    private String cropID;
    private String cropName; 
    private String productionDate;
    private String expirationDate;

    private int maxQuantity;
    private int price;

    ArrayList<String> images;
    ArrayList<Category> categories;

    private int rating;
    private String type;
    private String season;

    public ProductData(String cropID,
                      String cropName, 
                      String productionDate, 
                      String expirationDate,
                      int maxQuantity,
                      int price){
        
        this.cropID = cropID;
        this.cropName = cropName; 
        this.productionDate = productionDate; 
        this.expirationDate = expirationDate;
        this.maxQuantity = maxQuantity;
        this.price = price;  
        images = new ArrayList<String>();
        categories = new ArrayList<Category>();
    }

    public static ProductData getEmptyProductData() {
        
        return new ProductData("", "", "", "", 0, 0);
    }

    public String getCropName() { return cropName; }
    public String getProductionDate() { return productionDate; }
    public String getExpirationDate() { return expirationDate; }
    public int getMaxQuantity() { return maxQuantity; }
    public int getPrice() { return price; }
    public String getCropID() { return cropID; }

    public ArrayList<String> getImages() { return images; }
    
    public void setImages(ArrayList<String> images){
        this.images = images;
    }
    public void setCropID(String cropID) {
        this.cropID = cropID;
    }

    public ArrayList<Category> getCategories() { return categories; }
    public void addCategories(ArrayList<String> categories){
        Category ct;
        for(String c : categories){
            ct = Category.createCategory(c);

            this.categories.add(ct);

            if(ct.getCategoryTypeEnum() == CategoryType.RATING){
                rating = Integer.parseInt(ct.getValue());
            }else if (ct.getCategoryTypeEnum() == CategoryType.SEASON){
                season = ct.getValue();
            }else if (ct.getCategoryTypeEnum() == CategoryType.TYPE){
                type = ct.getValue();
            }
        }
    }

    public int getRating(){
        return rating;
    }

    public String getSeason(){
        return season;
    }

    public String getType(){
        return type;
    }

    public static void sortByPrice(ProductData[] products){
        Arrays.sort(products, new PriceComparator());
    }

    public static void sortByRating(ProductData[] products){
        Arrays.sort(products, new RatingComparator());
    }
}