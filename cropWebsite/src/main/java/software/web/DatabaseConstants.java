package software.web.database;

public class DatabaseConstants {
    
    final static String url = "jdbc:mysql://localhost:3306/softDB";
    final static String username = "god";
    final static String password = "god";

    /**
    * This is a static method that is used to get the url.
    * @param void
    *     The parameter is void.
    * @return
    *     An String is returned which contains the url.
    */
    public static String getUrl(){
        return url;
    }

    /**
    * This is a static method that is used to get the username.
    * @param void
    *     The parameter is void.
    * @return
    *     An String is returned which contains the password.
    */
    public static String getUsername(){
        return username;
    }
    
    /**
    * This is a static method that is used to get the password.
    * @param void
    *     The parameter is void.
    * @return
    *     An String is returned which contains the password.
    */
    public static String getPassword(){
        return password;
    }
    
}