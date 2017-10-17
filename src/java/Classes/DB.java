/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author shimantta
 */
public class DB {
    private static Connection con = null;
    private static String jdbc = "jdbc:mysql://localhost:3306/mydb";
    private static String user = "root";
    private static String password = "root";
    
    public static Connection getInstance() throws ClassNotFoundException, SQLException{
        if(con == null){
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(jdbc,user,password);
        }
        return con;
    }
}
