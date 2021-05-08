package software.web.products.database;

import java.util.regex.Pattern;


public class Category {

    private CategoryType type;
    private String value;

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

    public String getCategoryType() {
        
        if(type == CategoryType.SEASON){
            return "Season: ";
        }else if(type == CategoryType.RATING){
            return "Rating: ";
        }else if(type == CategoryType.TYPE){
            return "Type: ";
        }else return "";
    }

    public CategoryType getCategoryTypeEnum(){
        return type;
    }

    public void setCategoryType(CategoryType ct) {
        type = ct;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String v) {
        value = v;
    }

    private static String returnValue(String ip_str){
        String temp = "";

        for(int i = 3; i < ip_str.length(); i++){
            temp += ip_str.charAt(i);
        }
        return temp;
    }
}
    
