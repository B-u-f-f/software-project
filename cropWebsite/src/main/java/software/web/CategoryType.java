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
    private CategoryType(String regex){
        this.regex = regex;
    }

    public String getRegex(){ return regex; }
}