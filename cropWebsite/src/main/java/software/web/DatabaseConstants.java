package software.web.database;

public class DatabaseConstants {
    
    final static String url = "jdbc:mysql://localhost:3306/softDB";
    final static String username = "god";
    final static String password = "god";

    public static String getUrl(){
        return url;
    }

    public static String getUsername(){
        return username;
    }
    
    public static String getPassword(){
        return password;
    }
    
}