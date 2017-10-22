package Helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author shimantta
 */
public class User {
    private static String username;
    private static int id ;
    
    
    public static boolean Find(String username,String password) throws ClassNotFoundException, SQLException{
        ResultSet result = DB.SelectUser(username,password);
        result.last();
        int size = result.getRow();
        result.beforeFirst();
        if(size > 0 ){
            User.StoreData(result);
            return true;
        }else{
            return false;
        }
        
    }
    
    private static void StoreData(ResultSet result) throws SQLException{
        
        while(result.next()){
            id = result.getInt("id");
            username = result.getString("username");
        }
    }
    
    public static String GetUsername(){
        return username;
    }
    
    public static int GetId(){
        return id;
    }
}
