package software.web.products.database;

// Rating
// Season
// Type

public enum CategoryType {
    SEASON("^S: (Spring|Winter|Summer|Autumn)$"), 
    RATING("^R: (\\d)$"),
    TYPE("^T: (Fruit|Vegetable|Grain)$"),
    ERROR("");

    private final String regex;
    
    /**
    * This is a constructor that is used to set the regex for the CategoryType. 
    * @param regex
    *     There is a String parameter that contains the regex.
    */
    private CategoryType(String regex){
        this.regex = regex;
    }

    /**
    * This is a method that is used to get the regex of the categoryType.
    * @param void
    *     There is no parameter.
    * @return 
    *     A String is returned with the regex of the CategoryType.
    */
    public String getRegex(){ return regex; }
}