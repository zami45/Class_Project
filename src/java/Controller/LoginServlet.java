package Controller;

import Helper.DB;
import Helper.Hash;
import Helper.User;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        
        try { 
            boolean found = User.Find(username,password);
            HttpSession session = request.getSession();
            if(found){
                String name = User.GetUsername();
                int id = User.GetId();
               
                if(remember != null){
                    
                    String hash = Hash.makeHash(String.valueOf(id));
                    DB.InsertHash(hash,id);
                    Cookie ck = new Cookie("id_hash",hash);
                    ck.setMaxAge(365*24*60*60);
                    response.addCookie(ck);

                }
                
                session.setAttribute("id",String.valueOf(id));
                session.setAttribute("user",name);
                response.sendRedirect(request.getContextPath()+"/Views/Landing.jsp");
            }
        } catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
