package software.web.products.database;

import java.util.regex.Pattern;

 /**
* The Category.java is used to getCategoryType or setCategory type  
* The setCategoryType is used when we retrieve the categorytype from the form
* @author  Ritwik Sinha
* @version 1.0
*/


public class Category {

    private CategoryType type;
    private String value;


    /**
    * This is a static method which is used to make a Category Class Object with the data and return it.
    * @param c
    *     This is a Strinc c which contains all the data of the Crop's category.
    * @return 
    *     A Category class is being returned with the data of crop category.
    */
    public static Category createCategory(String c){
        Category ct = new Category();

        if(Pattern.matches(CategoryType.SEASON.getRegex(), c)){
            ct.setCategoryType(CategoryType.SEASON); 
            ct.setValue(returnValue(c));
        }else if(Pattern.matches(CategoryType.RATING.getRegex(), c)){
            ct.setCategoryType(CategoryType.RATING);
            ct.setValue(returnValue(c));
        }else if(Pattern.matches(CategoryType.TYPE.getRegex(), c)){
            ct.setCategoryType(CategoryType.TYPE);
            ct.setValue(returnValue(c));
        }else {
            ct.setCategoryType(CategoryType.ERROR);
            ct.setValue("");
        }

        return ct;
    }

    /**
    * This is a method that is used to get the category type from the class instance.
    * @param void
    *     There is no parameter.
    * @return 
    *     A String is returned with the category type.
    */
    public String getCategoryType() {
        
        if(type == CategoryType.SEASON){
            return "Season: ";
        }else if(type == CategoryType.RATING){
            return "Rating: ";
        }else if(type == CategoryType.TYPE){
            return "Type: ";
        }else return "";
    }

    /**
    * This is a method that is used to get the category type enum.
    * @param void
    *     There is no parameter.
    * @return 
    *     A CategoryType enum is returned from the Category class instance.
    */
    public CategoryType getCategoryTypeEnum(){
        return type;
    }

    /**
    * This is a method that is used to set the category type for the class instance.
    * @param ct
    *     There is a category type enum given as parameter.
    * @return 
    *     This returns a void.
    */
    public void setCategoryType(CategoryType ct) {
        type = ct;
    }

    /**
    * This is a method that is used to get the value from the class instance.
    * @param void
    *     There is no parameter.
    * @return 
    *     A String is returned with the value.
    */
    public String getValue() {
        return value;
    }

    /**
    * This is a method that is used to set the value for the class instance.
    * @param void
    *     There is a String parameter v which contains the value.
    * @return 
    *     This returns a void.
    */
    public void setValue(String v) {
        value = v;
    }

    /**
    * This is a static method that is used to get a String and then reverse the String.
    * @param ip_str
    *     There is String parameter which we have to reverse.
    * @return 
    *     A String is returned with contains the reversed value.
    */
    private static String returnValue(String ip_str){
        String temp = "";

        for(int i = 3; i < ip_str.length(); i++){
            temp += ip_str.charAt(i);
        }
        return temp;
    }
}
    
