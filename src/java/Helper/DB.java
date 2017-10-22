package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author shimantta
 */
public class DB {
    private static Connection con = null;
    private static String jdbc = "jdbc:mysql://localhost:3306/mydb";
    private static String user = "root";
    private static String password = "root";
    private static Statement statement;
    private static ResultSet result;
    
    public static Connection getConInstance() throws ClassNotFoundException, SQLException{
           if(con == null){
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(jdbc,user,password);
                        
           }
           return con; 
    }
    
    private static Statement getStatement() throws ClassNotFoundException, SQLException{
        statement = DB.getConInstance().createStatement();
        return statement;
    }
    public static ResultSet Select(String what,String Table) throws ClassNotFoundException, SQLException{

        String query = "select "+what+" From "+Table;
        result = DB.getStatement().executeQuery(query);
        return result;
    }
    
    public static ResultSet Insert(String username,String password,String email,String dob) throws ClassNotFoundException, SQLException{
        
        PreparedStatement stmt = DB.getConInstance().prepareStatement("Insert into users (username,password,dob,email) Values (?,?,?,?)");
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, dob);
        stmt.setString(4, email);
        stmt.execute();
        result = DB.getStatement().executeQuery("Select * From users order by id desc limit 1");
        return result;
    }
    
    public static ResultSet SelectUser(String username,String password) throws ClassNotFoundException, SQLException{
        PreparedStatement stmt = DB.getConInstance().prepareStatement("Select * from users where username = ? And password = ?");
        stmt.setString(1,username);
        stmt.setString(2,password);

        result = stmt.executeQuery();
        return result;
    }
    
    public static void InsertHash(String data,int id) throws ClassNotFoundException, SQLException{
        PreparedStatement stmt = DB.getConInstance().prepareStatement("Insert into login_session (hash,user_id) Values (?,?)");
        stmt.setString(1, data);
        stmt.setInt(2,id);

        stmt.execute();
    }
    
    public static int GetUserFromHash(String hash) throws ClassNotFoundException, SQLException{
        PreparedStatement stmt = DB.getConInstance().prepareStatement("Select * from login_session where hash = ?");
        stmt.setString(1,hash);
      

        result = stmt.executeQuery();
        int id = 0;
        while(result.next()){
            id = result.getInt("user_id");
        }
        
        return id;
    }
}
