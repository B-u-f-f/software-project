package software.web.products.database;

import java.util.ArrayList;
import java.util.Arrays;

//CropName, MaxQuantity , ProductionDate , ExpirationDate , Price 


import java.util.Comparator;

class PriceComparator implements Comparator<ProductData> {

    /**
    * This method is used to check if Product p1 has less price than Product p2 or not.
    * @param p1
    *     This is the ProductData object of p1.
    * @param p2
    *     This is the ProductData object of p2.
    * @return
    *     The function is returning an int according to the product price.
    */
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
    /**
    * This method is used to check if Product p1 has less rating than Product p2 or not.
    * @param p1
    *     This is the ProductData object of p1.
    * @param p2
    *     This is the ProductData object of p2.
    * @return
    *     The function is returning an int according to the product rating.
    */
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

    /**
    * This is a constructor to set the initial values of the class instance.
    * @param cropID
    *     This is the String cropID.
    * @param p2
    *     This is the String cropName.
    * @param p2
    *     This is the String productionDate.
    * @param p2
    *     This is the String expirationDate.
    * @param p2
    *     This is the int maxQuantity.
    * @param p2
    *     This is the int price.
    */  
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

    /**
    * This is a static function to get an empty ProductData object.
    * @param void
    *     There is no parameter for this fuction.
    * @return
    *     The function returns a empty ProductData object.
    */
    public static ProductData getEmptyProductData() {
        
        return new ProductData("", "", "", "", 0, 0);
    }

    public String getCropName() { return cropName; }
    public String getProductionDate() { return productionDate; }
    public String getExpirationDate() { return expirationDate; }
    public int getMaxQuantity() { return maxQuantity; }
    public int getPrice() { return price; }
    public String getCropID() { return cropID; }

    /**
    * This is a function to get a list of all the images of the Product Data.
    * @param void
    *     There is no parameter for this fuction.
    * @return
    *     The function returns a ArrayList<String> of image urls.
    */
    public ArrayList<String> getImages() { return images; }

    /**
    * This is a function to set a list of all the images of the Product Data.
    * @param images
    *     There is a ArrayList<String> of images that contains all the image urls.
    * @return
    *     The function returns void.
    */
    public void setImages(ArrayList<String> images){
        this.images = images;
    }

    /**
    * This is a function to set the cropID of the class instance.
    * @param cropID
    *     There is a String cropID.
    * @return
    *     The function returns void.
    */
    public void setCropID(String cropID) {
        this.cropID = cropID;
    }

    /**
    * This is a function to get a list of all the categories of the Product Data instance.
    * @param void
    *     There is no parameter for this fuction.
    * @return
    *     The function returns a ArrayList<Category> of all the categories.
    */
    public ArrayList<Category> getCategories() { return categories; }

    /**
    * This is a function to set categories to the Product Data instance.
    * @param categories
    *     This is a ArrayList<String> of the categores for this crop.
    * @return
    *     The function returns void.
    */
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

    /**
    * This is a function to get the rating of the crop.
    * @param void
    *     There is no parameter.
    * @return
    *     The function returns int which contains the rating of the crop.
    */
    public int getRating(){
        return rating;
    }

    /**
    * This is a function to get the season of the crop.
    * @param void
    *     There is no parameter.
    * @return
    *     The function returns String which contains the season of the crop.
    */
    public String getSeason(){
        return season;
    }

    /**
    * This is a function to get the type of the crop.
    * @param void
    *     There is no parameter.
    * @return
    *     The function returns String which contains the type of the crop.
    */
    public String getType(){
        return type;
    }

    /**
    * This is a static function to sort the ProductData array according to the Price.
    * @param products
    *     The parameter is a ProductData array.
    * @return
    *     The function returns void.
    */
    public static void sortByPrice(ProductData[] products){
        Arrays.sort(products, new PriceComparator());
    }

    /**
    * This is a static function to sort the ProductData array according to the Rating.
    * @param products
    *     The parameter is a ProductData array.
    * @return
    *     The function returns void.
    */
    public static void sortByRating(ProductData[] products){
        Arrays.sort(products, new RatingComparator());
    }
}